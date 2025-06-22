package org.example.streams;

import java.util.*;
import java.util.stream.*;

public class StreamNullDoubleTest {

    public static void main(String[] args) {
        // Create a large list with mixed values
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            if (i % 3 == 0) list.add(null);
            else if (i % 5 == 0) list.add((double) i);
            else list.add(i);
        }

        // Sequential
        long start = System.currentTimeMillis();
        long nullCount = list.stream().filter(Objects::isNull).count();
        long doubleCount = list.stream().filter(o -> o instanceof Double).count();
        long end = System.currentTimeMillis();
        System.out.println("Sequential: nulls=" + nullCount + ", doubles=" + doubleCount +
                ", time=" + (end - start) + "ms");

        // Parallel 50/50 not the case
        start = System.currentTimeMillis();
        nullCount = list.parallelStream().filter(Objects::isNull).count();
        doubleCount = list.parallelStream().filter(o -> o instanceof Double).count();
        end = System.currentTimeMillis();
        System.out.println("Parallel: nulls=" + nullCount + ", doubles=" + doubleCount +
                ", time=" + (end - start) + "ms");
    }
}
