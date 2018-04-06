package com.self.learning.search;

//its not working yet :(
public class FirstRepeatingElementsSortedArray {
    private final int[] ints;


    public FirstRepeatingElementsSortedArray() {
        ints = new int[] {
                1,
                2,
                3,
                4,
                5,
                6,
                7,
                7,
                8,
                9,
                10
        };
    }


    public static void main(String[] args) {
        FirstRepeatingElementsSortedArray instance = new FirstRepeatingElementsSortedArray();
        final int repeatingElement = instance.findFirstRepeatingElement(0, instance.ints.length - 1);
        System.out.println(repeatingElement);
    }


    private int findFirstRepeatingElement(final int low, final int high) {
        int mid = (low + high) / 2;
        if (mid != 0) {
            if ((ints[mid - 1] == ints[mid]) || (ints[mid] == ints[mid + 1])) {
                return ints[mid];
            } else {
                int repeatingElement = findFirstRepeatingElement(low, mid - 1);
                if (repeatingElement == -1) {
                    return findFirstRepeatingElement(mid + 1, high);
                }
            }
        } else if (ints[low] == ints[high]) {
            return ints[low];
        }
        return -1;
    }

}
