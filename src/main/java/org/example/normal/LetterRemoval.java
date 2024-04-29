package org.example.normal;

public class LetterRemoval {
  public static String removeLetter(String string, int n) {
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    for (String letter : alphabet.split("")) {
      while (!string.isEmpty() && string.contains(letter) && n-- > 0) {
        string = string.replaceFirst(letter, "");
      }
    }
    return string;
  }
}
/*Видали n символів з заданого рядка, використовуючи наступне правило:

спочатку видаляються всі букви 'a', потім букви 'b', потім 'c' і так далі */