package org.example;

public class CreditCard {
  public static boolean isValidCardNumber(String cardNumber) {
    StringBuilder stb = new StringBuilder(cardNumber);
    stb.reverse();
    int sum = 0;
    for (int i = 0;i < stb.length();i++) {
      if (i % 2 != 0) {
        int temp = (stb.charAt(i) - 48) * 2;
        if (temp > 9) {
          stb.setCharAt(i, Character.forDigit((temp - 9), 10));
        } else {
          stb.setCharAt(i, Character.forDigit(temp, 10));
        }
      }
      sum += (stb.charAt(i) - '0');
    }
    return sum % 10 == 0;
  }
}
