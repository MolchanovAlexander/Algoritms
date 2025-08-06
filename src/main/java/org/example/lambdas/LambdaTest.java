package org.example.lambdas;

import java.util.Arrays;
import java.util.List;

public class LambdaTest {
    public static void main(String[] args) {
        List<SomeClass> a = Arrays.asList(new SomeClass(), new SomeClass());
        List<Integer> list = a.stream()
                .map(item -> item.integer)
                .toList();
    }
}

class SomeClass {

    int integer = 0;

     public void increment() {
        integer++;
    }

    @Override
    public String toString() {
        return "SomeClass{" +
                "integer=" + integer +
                '}';
    }
}