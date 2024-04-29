package org.example.hard;

public class PrimeString {
    public static boolean isPrime(String string) {
        String res = "";
        for (int i = 0; i < string.length(); i++) {
            if (res.contains(String.valueOf(string.charAt(i)))) {
                if (string.charAt(0) == string.charAt(i)) {
                    return false;
                }
                break;
            }
            res = res + string.charAt(i);
        }
        return true;
    }
}
/* Mentor
public static boolean isPrime(String string) {
    return (string + string).indexOf(string, 1) == string.length();
  }
 */
