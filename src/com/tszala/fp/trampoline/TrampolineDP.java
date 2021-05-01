package com.tszala.fp.trampoline;

import java.util.stream.Stream;

public interface TrampolineDP<T> {

    T get();

    default TrampolineDP<T> jump() {
        return this;
    }

    default T result() {
        return get();
    }

    default boolean complete() {
        return true;
    }

    static <T> TrampolineDP<T> done(final T result) {
        return () -> result;
    }

    static <T> TrampolineDP<T> more(final TrampolineDP<TrampolineDP<T>> trampoline) {
        return new TrampolineDP<T>() {
            @Override
            public boolean complete() {
                return false;
            }

            @Override
            public TrampolineDP<T> jump() {
                return trampoline.result();
            }

            @Override
            public T get() {
                return trampoline(this);
            }

            T trampoline(final TrampolineDP<T> trampoline) {
                return Stream.iterate(trampoline, TrampolineDP::jump)
                        .filter(TrampolineDP::complete)
                        .findFirst()
                        .map(TrampolineDP::result)
                        .orElseThrow();
            }
        };
    }
}
