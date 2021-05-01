package com.tszala.fp;

public class Adder {

    public static int add(int a, int b) {
        while(b > 0) {
            a++;
            b--;
        }
        return a;
    }

}
