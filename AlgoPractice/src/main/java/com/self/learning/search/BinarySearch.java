package com.self.learning.search;

public class BinarySearch {
    private final int[] ints;


    private BinarySearch() {
        ints = new int[] {
                1,
                2,
                4,
                6,
                9,
                12,
                123,
                999,
                1000,
                1000,
                1001,1002,1003,1004,1005,1006
        };
    }


    private int doBinarySearch(final int item) {
        int low = 0;
        int high = ints.length - 1;
        int mid, guess;
        while (low <= high) {
            mid = (low + high) / 2;
            guess = ints[mid];
            if (guess == item) {
                return mid;
            } else if (guess < item) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        final int item = 1000;
        final int foundIndex = binarySearch.doBinarySearch(item);
        if (foundIndex != -1) {
            System.out.print(String.format("Item %d found at index %d", item, foundIndex));
        } else {
            System.out.print("Element not found");
        }
    }
}
