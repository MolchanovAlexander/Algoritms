package org.example;

import java.util.ArrayList;
import java.util.List;
import org.example.normal.PairsWithDifference;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class PairsWithDifferenceTest {

  private static final List<TestData> testData = new ArrayList<>();
  private static final PairsWithDifference solution = new PairsWithDifference();

  private static class TestData {
    int[] nums;
    int k;
    int expectedCount;

    TestData(int[] nums, int k, int expectedCount) {
      this.nums = nums;
      this.k = k;
      this.expectedCount = expectedCount;
    }
  }

  @BeforeClass
  public static void setup() {
    testData.add(new TestData(new int[]{1, 2, 2, 1}, 1, 4));
    testData.add(new TestData(new int[]{1, 3}, 3, 0));
    testData.add(new TestData(new int[]{3, 2, 1, 5, 4}, 2, 3));
    testData.add(new TestData(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, 10, 1));
    testData.add(new TestData(new int[]{1, 11, 21, 31, 41}, 20, 3));
    testData.add(new TestData(new int[]{0, 20, 40, 60, 80, 100}, 30, 0));
    testData.add(new TestData(new int[]{0, 30, 40, 60, 80, 90}, 30, 3));

    // Add more test cases as needed
  }

  @Test
  public void testCountKDifference() {
    for (TestData data : testData) {
      int actual = solution.countKDifference(data.nums, data.k);
      Assert.assertEquals("Failed for nums: " + arrayToString(data.nums) + " and k: " + data.k,
        data.expectedCount, actual);
    }
  }

  private String arrayToString(int[] arr) {
    StringBuilder sb = new StringBuilder();
    for (int value : arr) {
      if (sb.length() > 0) {
        sb.append(", ");
      }
      sb.append(value);
    }
    return "[" + sb + "]";
  }
}
