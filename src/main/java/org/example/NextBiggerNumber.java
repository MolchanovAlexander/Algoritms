package org.example;

import java.util.Arrays;

public class NextBiggerNumber {
  public static int getNextBiggerNumber(int n) {
    char[] digits = String.valueOf(n).toCharArray();
    for (int i = digits.length - 2; i >= 0; i--) {
      for (int j = digits.length-1; j > i; j--){
        if (digits[i] < digits[j]) {
          char temp = digits[i];
          digits[i] = digits[j];
          digits[j] = temp;
          Arrays.sort(digits, i + 1, digits.length);
          return Integer.parseInt(String.valueOf(digits));
        }
      }
    }
    return -1;
  }
}