package org.example;

import java.math.BigInteger;

public class Primorial {
    public static String getPrimorialOfNumber(int number) {
        BigInteger prime = new BigInteger("2");
        BigInteger result = new BigInteger("1");
        for (int i = 0; i < number; i++) {
            result = result.multiply(prime);
            prime = prime.nextProbablePrime();
        }
        return result.toString();
    }
}
