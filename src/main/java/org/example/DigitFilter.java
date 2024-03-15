package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DigitFilter {
    public static void main(String[] args) {
        String randomString = "a1b2c3d4e0f5g6h7i8j9k";
        List<Integer> filteredDigits = filterDigits(randomString);
        System.out.println("Filtered digits: " + filteredDigits);
    }

    public static List<Integer> filterDigits(String input) {
        List<Integer> digits = new ArrayList<>();
        Pattern pattern = Pattern.compile("(?<![0-9])\\d(?!0)|(?<!\\d)0(?!\\d)");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String digitStr = matcher.group();
            digits.add(Integer.parseInt(digitStr));
        }

        return digits;
    }
}
