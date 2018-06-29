package com.self.learning.codility.iterations;


import static java.lang.Integer.max;


/**
 * A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones
 * at both ends in the binary representation of N.
 * <p>
 * For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has
 * binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20
 * has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation
 * 1111 and has no binary gaps. The number 32 has binary representation 100000 and has no binary gaps.
 * <p>
 * Write a function:
 * <p>
 * int solution(int N);
 * <p>
 * that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N
 * doesn't contain a binary gap.
 * <p>
 * For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so
 * its longest binary gap is of length 5. Given N = 32 the function should return 0, because N has binary
 * representation '100000' and thus no binary gaps.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [1..2,147,483,647].
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(log(N));
 * expected worst-case space complexity is O(1).
 */

public class BinaryGap {
    public static void main(String[] args) {
        long n = 32;
        final long longestBinaryGap = solution(n);
        System.out.println(longestBinaryGap);
    }


    private static long solution(long n) {
        while (n > 0 && n % 2 == 0) {
            n = n / 2;
        }
        long maxBinaryGap = 0;
        while (n > 0) {
            long binaryGap = 0;
            while (n % 2 == 0) {
                n = n / 2;
                binaryGap++;
            }
            if (binaryGap > maxBinaryGap) {
                maxBinaryGap = binaryGap;
            }
            n = n >> 1;
        }
        return maxBinaryGap;
    }


    private static int solution(int N) {
        int maxGap = 0;
        int currentGap = 0;

        while (N > 0 && N % 2 == 0) {
            N = N / 2;
        }

        while (N > 0) {
            int remainder = N % 2;
            if (remainder == 0) {
                currentGap++;
            } else {
                if (currentGap != 0) {
                    maxGap = max(currentGap, maxGap);
                    currentGap = 0;
                }
                N = N / 2;
            }
        }

        return maxGap;
    }
}
