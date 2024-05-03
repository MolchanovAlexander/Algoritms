package org.example.streams;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class WordLists {
  public static List<Character> getCharacterAtPosition(List<String> strings, int position) {
    
    return strings.stream()
    .filter(Objects::nonNull)
                .map(String::toLowerCase)
                .map(s ->  s.charAt(position))
                .sorted()
    .collect(Collectors.toList());
  }
}