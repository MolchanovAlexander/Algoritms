package org.example.normal;

import java.util.LinkedList;

public class BackwardsPrimes {
    public static String getBackwardsPrimes(long start, long end) {
        System.out.println(start + " -s e-" + end);
        if (end < 13) {
            return "";
        }
        LinkedList<String> sss = new LinkedList<>();
        for (long i = start; i <= end; i++) {
            if (i > 12 && isPrime(i) && isBackPrime(i)) {
                sss.add(String.valueOf(i));
            }
        }
        return String.join(" ", sss);
    }

    public static boolean isBackPrime(long number) {
        StringBuilder stb = new StringBuilder();
        stb.append(number);
        stb.reverse();
        return isPrime(Long.parseLong(stb.toString()));
    }

    public static boolean isPrime(long number) {
        if (number <= 1) {
            return false;
        }
        if (number == 2 || number == 3) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }
        for (long i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
/* mentor
import java.math.BigInteger;

public class BackwardsPrimes {
  public static String getBackwardsPrimes(long start, long end) {
    StringBuilder result = new StringBuilder();
    StringBuilder reverser = new StringBuilder();

    for (int i = (int) start; i <= end; i++) {
      int reversed = Integer.parseInt(reverser.append(i).reverse().toString());
      BigInteger bigInteger = BigInteger.valueOf(i);
      BigInteger reversedInteger = BigInteger.valueOf(reversed);

      if (!bigInteger.equals(reversedInteger)) {
        boolean isBackwardsReadPrime = bigInteger.isProbablePrime((int) Math.log(i))
          && reversedInteger.isProbablePrime((int) Math.log(reversed));
        if (isBackwardsReadPrime) {
          result.append(i).append(" ");
        }
      }
      reverser.setLength(0);
    }
    return result.toString().trim();
  }
}
 */
