package com.self.learning.random;

import static java.lang.System.*;
import static java.lang.System.out;

import java.util.Scanner;


public class Fibonacci {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] cache = new long[n + 1];
        cache[0] = 0;
        cache[1] = 1;
        fib(n, cache);
        for (final long l : cache) {
            out.print(l + ",");
        }
    }


    private static long fib(final int i, final long[] cache) {
        if (i == 0) { return 0; }
        if (i == 1) { return 1; }
        if (cache[i] > 0) { return cache[i]; }
        cache[i] = fib(i - 1, cache) + fib(i - 2, cache);
        return cache[i];
    }
}
