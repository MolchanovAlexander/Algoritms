package org.example;

import org.example.hard.PositionsAverage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class PositionsAverageTest {
  private static final Map<String, Double> data = new HashMap<>();

  @BeforeClass
  public static void beforeClass() {
    data.put("1234, 1567, 5268, 5237", 33.3333333336);
    data.put("466960, 069060, 494940, 060069, 060090, 640009, 496464, 606900, 004000, 944096", 26.6666666667);
    data.put("444996, 699990, 666690, 096904, 600644, 640646, 606469, 409694, 666094, 606490", 29.2592592593);
    data.put("4444444, 4444444, 4444444, 4444444, 4444444, 4444444, 4444444, 4444444", 100.0);
    data.put("0, 0, 0, 0, 0, 0, 0, 0", 100.0);
    data.put("940040469444960, 940064644064409, 649990600499666, 400049904446006, 969490994460660, 904044664609090", 26.6666666668);
  }

  @Test
  public void getAveragePercentage_checkSubstrings() {
    for (Map.Entry<String, Double> entry : data.entrySet()) {
      String input = entry.getKey();
      double expected = entry.getValue();
      double actual = PositionsAverage.getAveragePercentage(input);
      double delta = 1e-9;
      Assert.assertEquals(String.format("The average should be %f for the string \"%s\"\n",
        expected, input), expected, actual, delta);
    }
  }
}
