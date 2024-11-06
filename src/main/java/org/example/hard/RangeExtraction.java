package org.example.hard;

import java.util.Arrays;

public class RangeExtraction {
    public static String extractRange(int[] nums) {
        System.out.println(Arrays.toString(nums));
        if (nums.length == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            int rangeStart = nums[i];
            result.append(rangeStart);
            for (int j = i + 1; j <= nums.length; j++) {
                if (j == nums.length || nums[j] != rangeStart + (j - i)) {
                    if (j - i >= 3) {
                        result.append('-').append(nums[j - 1]);
                        i = j - 1;
                    }
                    result.append(',');
                    break;
                }
            }
        }

      System.out.println(result);
        return result.deleteCharAt(result.length() - 1).toString();
    }
}

