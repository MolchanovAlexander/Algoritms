package org.example.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class PositionsAverage {
    public static void main(String[] args) {
        String s1 = "1234, 1567, 5268, 5237"; //33.3333333336);
        String s2 = "466960, 069060, 494940, 060069, 060090, 640009, 496464, 606900, 004000, 944096"; //26.6666666667);
        String s3 = "444996, 699990, 666690, 096904, 600644, 640646, 606469, 409694, 666094, 606490"; //29.2592592593);
        String s4 = "4444444, 4444444, 4444444, 4444444, 4444444, 4444444, 4444444, 4444444"; //100.0);
        System.out.println(getAveragePercentage(s1));

    }

    public static double getAveragePercentage(String string) {
        String[] strings = string.split(", ");
        LinkedList<List<Integer>> temp = new LinkedList<>();
        List<Integer> first;
        List<Integer> last;
        List<Double> average = new ArrayList<>();
        for (String in : strings) {
            temp.add(new LinkedList<>(new java.util.ArrayList<>(in.chars().boxed().toList())));
        }
        while (temp.size() > 1) {
            first = temp.get(0);
            for (int i = 1; i < temp.size(); i++) {
                last = new ArrayList<>(temp.get(i));
                average.add(filtering(last, first) / (double) first.size());
            }
            temp.removeFirst();
        }
        double sum = average.stream().mapToDouble(Double::doubleValue).sum();
        return sum / average.size() * 100;
    }

    public static int filtering(List<Integer> a, List<Integer> b) {
        int count = 0;
        for (int i = 0; i < a.size(); i++) {
            if (Objects.equals(a.get(i), b.get(i))) {
                count++;
            }
        }
        return count;
    }
    /*
    public static double getAveragePercentage(String string) {
    String[] substrings = string.split(", ");
    int maxComparisons = substrings.length * (substrings.length - 1) * substrings[0].length() / 2;
    int totalSimilarPositions = 0;
    for (int i = 0; i < substrings.length; i++) {
      for (int j = i + 1; j < substrings.length; j++) {
        totalSimilarPositions += countSimilarPositions(substrings[i], substrings[j]);
      }
    }
    return (double) totalSimilarPositions * 100 / maxComparisons;
  }

  private static int countSimilarPositions(String str1, String str2) {
    int similarPositionsCount = 0;
    for (int i = 0; i < str1.length(); i++) {
      if (str1.charAt(i) == str2.charAt(i)) {
        similarPositionsCount++;
      }
    }
    return similarPositionsCount;
  }
     */
}
