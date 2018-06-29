package com.self.learning.random;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class ArrayRangeCompacting {

    /*
     * Complete the solution function below.
     */
    static String solution(int[] array) {
        /*
         * Write your code here.
         */
        int length = array.length;
        String output = String.valueOf(array[0]);
        for (int i = 0; i < length - 1; ) {
            int count = 0;
            while ((i < length - 1) && (Math.abs(array[i + 1] - array[i]) == 1)) {
                i++;
                count++;
            }
            if(count == 0){
                i++;
            }
            if (count > 1) {
                output = output + "-" + array[i];
            } else {
                output = output + "," + array[i];
            }
        }
        return output;
    }


    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        final int[] array = new int[] {
                12,
                -3,
                -2,
                -1,
                5,
                6,
                7,
                9,
                11,
                12,
                13,
                15,
                16
        };
        String res = solution(array);
        System.out.println(res);
        scanner.close();
    }
}
