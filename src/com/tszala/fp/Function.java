package com.tszala.fp;

@FunctionalInterface
public interface Function<T, U> {

  U apply(T arg);

  static <W> Function compose(Function<W, W> f1, Function<W, W> f2) {
    return (Function<W, W>) arg -> f1.apply(f2.apply(arg));
  }

  static <P, Q, R> Function<Function<Q, R>, Function<Function<P, Q>, Function<P, R>>> higherCompose() {
    return f -> g -> x -> f.apply(g.apply(x));
  }

  static <P, Q, R> Function<Function<P, Q>, Function<Function<Q, R>, Function<P, R>>> higherAndThen() {
    return x -> y -> z -> y.apply(x.apply(z));
  }

  static <T,U,V> Function<U, Function<T,V>> reverseArgs(Function<T, Function<U, V>> f) {
    return x->y->f.apply(y).apply(x);
  }
}
