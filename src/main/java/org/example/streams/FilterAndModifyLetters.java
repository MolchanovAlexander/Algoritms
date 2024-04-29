package org.example.streams;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FilterAndModifyLetters {
    public static String filterLetters(String input) {
        return IntStream.range(0, input.length())
                .filter(i -> i % 2 == 0)
                .mapToObj(input::charAt)
                .map(Object::toString)
                .collect(Collectors.joining())
                .toUpperCase();
    }
}
//deleting all chars where index % 2 ! = 0; and making string from this.