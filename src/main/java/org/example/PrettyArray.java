package org.example;

public class PrettyArray {
    public static boolean isArrayPretty(int[] array) {
        int countOfMismatch = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] != array[j] - 1 && array[i] != array[j] + 1) {
                    countOfMismatch++;
                } //find at least 1 pretty member from all array
            }
            if (countOfMismatch == array.length) {
                return false; // if no one found return ;
            }
            countOfMismatch = 0; // preparing for new cycle
        }
        return true;
    }

    public static boolean isBadunPretty(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] == array[j] - 1 || array[i] == array[j] + 1) {
                    count++; //find at least 1 pretty member from all array
                    break; // then break cycle;
                }
            }
        } //find at least 1 pretty member for all other members
        return count == array.length;
    }
}
