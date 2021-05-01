package com.tszala.fp;

import java.util.function.Consumer;

public interface ThrowingFunction<T, R, E extends Throwable> {
  static <T, R, E extends Throwable> Function<T, R> unchecked(ThrowingFunction<T,R, E> func) {

    return (t) -> {
      try {
        return func.apply(t);
      } catch (Throwable e) {
        throw new RuntimeException(e);
      }
    };
  }


  R apply(T v) throws E;
}
