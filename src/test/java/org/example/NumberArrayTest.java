package org.example;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumberArrayTest {
  private static final Map<int[], Integer> data = new HashMap<>();

  @BeforeClass
  public static void beforeClass() {
    data.put(new int[]{18}, 18);
    data.put(new int[]{0}, 0);
    data.put(new int[]{-2}, 0);
    data.put(new int[]{3, 4, 5, 6, 7, 8}, 33);
    data.put(new int[]{6, 1, 2, -2, 7, 12, -5, 2}, 26);
    data.put(new int[]{0, 0, 0}, 0);
    data.put(new int[]{-2, -3, -15}, 0);
    data.put(new int[]{8, 11, 3, -2, -1, -5, 2}, 22);
    data.put(new int[]{2, -4, 0, 10, 4, 5, 12, -13, 6, 2}, 31);
    data.put(new int[]{-22, -8, -1, -3, 5, 19, 5}, 29);
    data.put(new int[]{-1, 7, -4, -30}, 7);
    data.put(new int[]{}, 0);
  }

  @Test
  public void getMaxSubarraySum_numberArray() {
    for (Map.Entry<int[], Integer> entry : data.entrySet()) {
      int[] input = entry.getKey();
      int expected = entry.getValue();
      int actual = NumberArray.getMaxSubarraySum(input);
      Assert.assertEquals(String.format("The method should return %d for the input array %s\n",
        expected, Arrays.toString(input)), expected, actual);
    }
  }
}
