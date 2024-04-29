package org.example.hard;

public class DoubleCola {
    public static String getNthPerson(String[] names, int n) {
        int line = names.length;
        int copies = 1;
        while (n > line * copies) {
            n -= line * copies;
            copies *= 2;
        }
        return names[(n - 1) / copies];
    }
}
/* that things with linkedlists causes OutOfMemory
mentor did this
 public class DoubleCola {
  public static String getNthPerson(String[] names, int n) {
    int line = names.length;
    int copies = 1;
    while (n > line * copies) {
      n -= line * copies;
      copies *= 2;
    }
    return names[(n - 1) / copies];
  }
} */