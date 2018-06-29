package com.self.learning.codility.arrays;

import static java.lang.System.out;

import java.util.Arrays;


/**
 * An array A consisting of N integers is given. Rotation of the array means that each element is shifted right by
 * one index, and the last element of the array is moved to the first place. For example, the rotation of array A =
 * [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one index and 6 is moved to the first place).
 * <p>
 * The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.
 * <p>
 * Assume that the following declarations are given:
 * <p>
 * struct Results {
 * int * A;
 * int N; // Length of the array
 * };
 * <p>
 * Write a function:
 * <p>
 * struct Results solution(int A[], int N, int K);
 * <p>
 * that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.
 * <p>
 * For example, given
 * <p>
 * A = [3, 8, 9, 7, 6]
 * K = 3
 * the function should return [9, 7, 6, 3, 8]. Three rotations were made:
 * <p>
 * [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
 * [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
 * [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
 * For another example, given
 * <p>
 * A = [0, 0, 0]
 * K = 1
 * the function should return [0, 0, 0]
 * <p>
 * Given
 * <p>
 * A = [1, 2, 3, 4]
 * K = 4
 * the function should return [1, 2, 3, 4]
 * <p>
 * Assume that:
 * <p>
 * N and K are integers within the range [0..100];
 * each element of array A is an integer within the range [−1,000..1,000].
 * In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
 */

public class CyclicRotation {
    public static void main(String[] args) {
        int[] A = {
                1,2,3
        };
        int noOfRotations = 3;
        int[] result = solution(A, noOfRotations);
        out.println(Arrays.toString(result));
    }


    private static int[] solution(final int[] A, int K) {
        if(A.length == 0 || A.length == 1){
            return A;
        }
        final int length = A.length;
        int[] result = new int[length];
        if (K >= length) {
            K = K - length;
        }
        if (K == 0) {
            return A;
        }
        int i;
        int offset = length - K;
        for (i = 0; i < K; i++) {
            result[i] = A[offset + i];
        }
        for (int j = 0; j < offset && i < length; i++, j++) {
            result[i] = A[j];
        }
        return result;
    }
}
