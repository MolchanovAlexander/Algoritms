package org.example.normal;

public class AlphabeticalSubstring {
    public static String getLongestAlphabeticalSubstring(String letters) {
        int start = 0;
        int end = 0;
        for (int i = 1, j = 0; i < letters.length(); i++) {
            if (letters.charAt(i - 1) > letters.charAt(i)) {
                j = i;
            } else if (i - j > end - start) {
                start = j;
                end = i;
            }
        }
        return letters.substring(start, end + 1);
    }
}