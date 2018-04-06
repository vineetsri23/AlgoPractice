package com.self.learning.sort;

public class SelectionSort {
    private final int[] array = new int[] {
            5,
            3,
            6,
            2,
            10
    };


    private int[] doSelectionSort() {
        for (int i = 0; i < array.length - 1; i++) {
            int smallest = array[i];
            int smallest_index = i;
            for (int j = i + 1; j < array.length - 1; j++) {
                if (smallest > array[j]) {
                    smallest = array[j];
                    smallest_index = j;
                }
            }
            array[smallest_index] = array[i];
            array[i] = smallest;
        }
        return array;
    }


    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] output = selectionSort.doSelectionSort();
        for (int element : output) {
            System.out.print(element + ",");
        }
    }
}
