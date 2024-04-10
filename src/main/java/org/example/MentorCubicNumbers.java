package org.example;

import java.util.ArrayList;

public class MentorCubicNumbers {
    public static final String NOT_DIGITS = "[^\\d]";
    public static final String GROUPS_OF_THREE = "(?<=\\G...)";

    public static String findCubicNumbers(String string) {
        var cubes = new ArrayList<String>();
        for (String num : string.replaceAll(NOT_DIGITS, " ").trim().split("\\s+")) {
            for (String top3 : num.split(GROUPS_OF_THREE)) {
                if (top3.equals(top3.chars().map(n -> (int) Math.pow(n - 48., 3)).sum() + "")) {
                    cubes.add(top3);
                }
            }
        }
        return cubes.isEmpty()
                ? "Unlucky"
                : String.join(" ", cubes) + " " + cubes.stream()
                .mapToInt(Integer::parseInt)
                .sum() + " Lucky";
    }
}