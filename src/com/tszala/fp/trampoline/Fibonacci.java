package com.tszala.fp.trampoline;

public class Fibonacci {
    public static TrampolineDP<Integer> loop(int times, int prod) {
        if (times == 0) {
            return TrampolineDP.done(prod);
        } else {
            return TrampolineDP.more(() -> loop(times - 1, prod * times));
        }
    }

    public static void main(String[] args) {
        System.out.println(String.format("Fibonacci of %d and %d is %d", 5, 4,loop(5,1).result()));
    }

}
