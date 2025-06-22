package org.example.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParallelStreamExample {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("Sequential Stream:");
        long start = System.currentTimeMillis();
        List<Integer> result1 = numbers.stream()
            .map(ParallelStreamExample::simulateExpensiveOperation)
            .toList();
        long end = System.currentTimeMillis();
        System.out.println("Result: " + result1);
        System.out.println("Time taken (sequential): " + (end - start) + " ms\n");

        System.out.println("Parallel Stream:");
        start = System.currentTimeMillis();
        List<Integer> result2 = numbers.parallelStream()
            .map(ParallelStreamExample::simulateExpensiveOperation)
            .toList();
        end = System.currentTimeMillis();
        System.out.println("Result: " + result2);
        System.out.println("Time taken (parallel): " + (end - start) + " ms");
    }

    private static Integer simulateExpensiveOperation(Integer number) {
        try {
            Thread.sleep(500); // simulate delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Processed by " + Thread.currentThread().getName() + ": " + number);
        return number * 2;
    }
}
