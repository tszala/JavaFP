package com.tszala.fp.trampoline;

public class FactorialMain {
    public static void main(String[] args) {
        System.out.println(String.format("Factorial of 4 is %d", Factorial.createTrampoline(4, 1).compute()));
    }
}
