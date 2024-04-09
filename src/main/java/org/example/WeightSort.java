package org.example;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WeightSort {
  public static String orderWeights(String weights) {
    return Stream.of(weights.trim().split(" +"))
      .sorted()
      .sorted(Comparator.comparingInt(o -> o.chars().map(Character::getNumericValue).sum()))
      .collect(Collectors.joining(" "));
  }
}
/*data.put("100", "100");
    data.put("105 107", "105 107");
    data.put("21 101", "101 21");
    data.put("90 81", "81 90");
    data.put("50 50 50", "50 50 50");
    data.put("90 98 99 100 101 102", "100 101 102 90 98 99");
    data.put("80 44 53 404 26 800 71", "26 404 44 53 71 80 800"); */