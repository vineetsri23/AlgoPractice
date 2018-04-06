package com.self.learning.shuffle;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class ArrayShuffle {
    public static void main(String[] args) {
        int[] intArray = {
                1,
                2,
                3,
                4,
                5,
                6,
                16,
                15,
                14,
                13,
                12,
                11
        };
        shuffleArray(intArray);
        for (int i : intArray) {
            System.out.println(i + " ");
        }
    }


    //Implementing Fischer-Yates Shuffle Algorithm
    private static void shuffleArray(final int[] intArray) {
        Random random = ThreadLocalRandom.current();
        for (int i = intArray.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int ele = intArray[index];
            intArray[index] = intArray[i];
            intArray[i] = ele;
        }
    }
}
