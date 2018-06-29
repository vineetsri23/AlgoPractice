package com.self.learning.codility.timecomplexity;

import static java.lang.System.out;

import java.util.Arrays;


/**
 * A non-empty array A consisting of N integers is given. Array A represents numbers on a tape.
 * <p>
 * Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P],
 * A[P + 1], ..., A[N − 1].
 * <p>
 * The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... +
 * A[N − 1])|
 * <p>
 * In other words, it is the absolute difference between the sum of the first part and the sum of the second part.
 * <p>
 * For example, consider array A such that:
 * <p>
 * A[0] = 3
 * A[1] = 1
 * A[2] = 2
 * A[3] = 4
 * A[4] = 3
 * We can split this tape in four places:
 * <p>
 * P = 1, difference = |3 − 10| = 7
 * P = 2, difference = |4 − 9| = 5
 * P = 3, difference = |6 − 7| = 1
 * P = 4, difference = |10 − 3| = 7
 * Write a function:
 * <p>
 * int solution(int A[], int N);
 * <p>
 * that, given a non-empty array A of N integers, returns the minimal difference that can be achieved.
 * <p>
 * For example, given:
 * <p>
 * A[0] = 3
 * A[1] = 1
 * A[2] = 2
 * A[3] = 4
 * A[4] = 3
 * the function should return 1, as explained above.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [2..100,000];
 * each element of array A is an integer within the range [−1,000..1,000].
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
 */

public class TapeEquilibrium {
    public static int solution(int[] A) {
        // write your code in Java SE 8
        int[] sum = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (i == 0) {
                sum[i] = A[i];
            } else {
                sum[i] = sum[i - 1] + A[i];
            }
        }
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < A.length - 1; i++) {
            result = Math.min(result, Math.abs(sum[A.length - 1] - 2 * sum[i]));
        }
        return result;
    }


    public static void main(String[] args) {
        int[] A = {
                3,
                1,
                2,
                4,
                3
        };
        int result = solution(A);
        out.println(result);
    }
}
