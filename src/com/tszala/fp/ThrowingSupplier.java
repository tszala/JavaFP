package com.tszala.fp;

import java.util.function.Supplier;

public interface ThrowingSupplier<T,E extends Throwable> {

  static <T, E extends Throwable> Supplier<T> unchecked(ThrowingSupplier<T, E> consumer) {

    return () -> {
      try {
        return consumer.get();
      } catch (Throwable e) {
        throw new RuntimeException(e);
      }
    };
  }

  T get();

}
