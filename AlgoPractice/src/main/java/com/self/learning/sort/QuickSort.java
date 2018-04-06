package com.self.learning.sort;

public class QuickSort {

    private void doQuickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            doQuickSort(array, low, pi - 1);
            doQuickSort(array, pi + 1, high);
        }
    }


    private int partition(final int[] array, final int low, final int high) {
        int pivot = array[high];
        int i = low - 1;
        int temp;
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }


    /* A utility function to print array of size n */
    private static void printArray(int arr[]) {
        for (final int anArr : arr) { System.out.print(anArr + " "); }
        System.out.println();
    }


    // Driver program
    public static void main(String args[]) {
        int arr[] = {
                10,
                7,
                8,
                9,
                1,
                5
        };
        int n = arr.length;

        QuickSort ob = new QuickSort();
        ob.doQuickSort(arr, 0, n - 1);

        System.out.println("sorted array");
        printArray(arr);
    }
}