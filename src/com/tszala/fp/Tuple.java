package com.tszala.fp;


public class Tuple<L,R> {

  private final L _1;
  private final R _2;

  public Tuple(L left, R right) {
    this._1 = left;
    this._2 = right;
  }
}
