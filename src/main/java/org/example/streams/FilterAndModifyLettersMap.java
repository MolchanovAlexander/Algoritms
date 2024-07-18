package org.example.streams;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FilterAndModifyLettersMap {
    public static Map<Character, Integer> filterLetters(String input) {
        return IntStream.range(0, input.length())
                .filter(i -> i % 2 == 0)
                .mapToObj(c -> Character.toUpperCase(input.charAt(c)))
                .filter(Character::isLetterOrDigit) // Filter out non-letter/digit characters
                .collect(Collectors.toMap(
                        c -> c, // Key is character
                        c -> (int)c // Value is numeric value of character or character itself
                ));

    }
}
//deleting all chars where index % 2 ! = 0; and making map from this.