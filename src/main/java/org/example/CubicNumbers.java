package org.example;

import java.util.LinkedList;
import java.util.List;

public class CubicNumbers {
    public static String findCubicNumbers(String string) {
        if (string.isEmpty()) {
            return "Unlucky";
        }
        List<Character> charsList = new LinkedList<>(string.chars().mapToObj(i -> (char) i).toList());
        List<String> forProcess = new LinkedList<>();
        String temp = "";
        for (int i = 0; i < charsList.size() - 1; i++) {

            System.out.println("temp:" + temp + " " + charsList.get(i));
            if (Character.isDigit(charsList.get(i))) {
                temp = temp + charsList.get(i);
            }
            if (temp.length() > 2 || (!Character.isDigit(charsList.get(i + 1)) && temp.length() > 0)) {
                forProcess.add(temp);
                temp = "";
            }
        }
        if (Character.isDigit(charsList.get(charsList.size() - 1))) {
            temp = temp + charsList.get(charsList.size() - 1);
            forProcess.add(temp);
        }
        List<String> forCubicNumbers = new LinkedList<>();
        for (String s : forProcess) {
            if (s.length() == 3 && Math.pow(s.toCharArray()[0] - '0', 3)
                    + Math.pow(s.toCharArray()[1] - '0', 3)
                    + Math.pow(s.toCharArray()[2] - '0', 3)
                    == Integer.parseInt(s)) {
                forCubicNumbers.add(s);
            } else if (s.length() == 2 && Math.pow(s.toCharArray()[0] - '0', 3)
                    + Math.pow(s.toCharArray()[1] - '0', 3)
                    == Integer.parseInt(s)) {
                forCubicNumbers.add(s);
            } else if (s.length() == 1 && Math.pow(s.toCharArray()[0] - '0', 3)
                    == Integer.parseInt(s)) {
                forCubicNumbers.add(s);
            }
        }
        int res = forCubicNumbers.stream().mapToInt(Integer::parseInt).sum();

        switch (forCubicNumbers.size()) {
            case 3 -> {
                return forCubicNumbers.get(0) + " " + forCubicNumbers.get(1) + " " + forCubicNumbers.get(2) + " " + res + " Lucky";
            }
            case 1 -> {
                return forCubicNumbers.get(0) + " " + res + " Lucky";
            }
            default -> {
                return "Unlucky";
            }
        }
    }
}
