package com.self.learning.search;

public class SearchSubString {

    public static void main(String[] args) {
        String parentString = "AABAABAAAA";
        String searchString = "AABAAAA";
        int i = 0, j = 0;
        for (; i < parentString.length() && j < searchString.length(); i++) {
            if (parentString.charAt(i) == searchString.charAt(j)) {
                j++;
            } else {
                j = 0;
            }
        }
        if (j == searchString.length()) {
            System.out.print("searchString found");
        }
    }
}
