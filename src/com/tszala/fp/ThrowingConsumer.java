package com.tszala.fp;


import java.util.function.Consumer;


public interface ThrowingConsumer<T, E extends Throwable> {

  static <T, E extends Throwable> Consumer<T> unchecked(ThrowingConsumer<T, E> consumer) {

    return (t) -> {
      try {
        consumer.accept(t);
      } catch (Throwable e) {
        throw new RuntimeException(e);
      }
    };
  }


  void accept(T v) throws E;
}
