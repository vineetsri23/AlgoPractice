package com.self.learning.codility.timecomplexity;

/**
 * An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)],
 * which means that exactly one element is missing.
 * <p>
 * Your goal is to find that missing element.
 * <p>
 * Write a function:
 * <p>
 * int solution(int A[], int N);
 * <p>
 * that, given an array A, returns the value of the missing element.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 2
 * A[1] = 3
 * A[2] = 1
 * A[3] = 5
 * the function should return 4, as it is the missing element.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [0..100,000];
 * the elements of A are all distinct;
 * each element of array A is an integer within the range [1..(N + 1)].
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(1) (not counting the storage required for input arguments).
 */

public class PermMissingElem {
    public static void main(String[] args) {
        PermMissingElem permMissingElem = new PermMissingElem();
        int[] targetArray = new int[99999];
        for (int i = 0; i <= 99998; i++) {
            if (i == 12344) {
                //do nothing
            }  else {
                targetArray[i] = i + 1;
            }
        }
        //targetArray[12343] = 100000;
        targetArray[12344] = 100001;
        System.out.println(permMissingElem.solution(targetArray));
    }


    public int solution(int[] A) {
        // write your code in Java SE 8
        Long missingElement = ((long) (A.length + 1) * (A.length + 2) / 2);
        for (final int aA : A) {
            missingElement -= aA;
        }
        return missingElement.intValue();
    }
}
