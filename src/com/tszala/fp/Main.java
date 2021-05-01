package com.tszala.fp;

import com.tszala.fp.Adder;

public class Main {

  public static void main(String[] args) {
    System.out.println("Hello World!");

    int a = 10;
    int b = 10;

    System.out.println(String.format("Adder of %d and %d: %d", a, b, Adder.add(10, 10)));

    Function<Integer, Integer> triple = arg -> 3 * arg;

    Function<Integer, Integer> square = arg -> arg * arg;

    Function<Integer, Function<Integer, Integer>> add = a1 -> a2 -> a1 + a2;

    BinaryOperator add2 = x -> y -> x + y;

    System.out.println(add.apply(10)
        .apply(11));
    Main m = new Main();

    System.out.println(String.format("Factorial of 10 %d",m.factorial.apply(10)));

  }

  public Function<Integer, Integer> factorial = arg -> arg == 0 ? 1 : arg * this.factorial.apply(arg-1);
//    {
//        factorial = arg -> arg == 0 ? 1 : arg * factorial.apply(arg-1);
//    }

  public static int factorial2(int n) {
      return n == 0 ? 1 : n * factorial2(n - 1);
  }
}
