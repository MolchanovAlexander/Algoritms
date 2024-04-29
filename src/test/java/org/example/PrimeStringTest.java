package org.example;

import org.example.hard.PrimeString;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class PrimeStringTest {
  private static final Map<String, Boolean> data = new HashMap<>();

  @BeforeClass
  public static void beforeClass() {
    data.put("acdc", true);
    data.put("gggg", false);
    data.put("lalalala", false);
    data.put("r", true);
    data.put("xyz", true);
    data.put("otto", true);
    data.put("deydhkdeydhkdeydhkdeydhkdeydhkdeydhk", false);
    data.put("", true);
  }

  @Test
  public void isPrime_inputString() {
    for (Map.Entry<String, Boolean> entry : data.entrySet()) {
      String input = entry.getKey();
      boolean expected = entry.getValue();
      boolean actual = PrimeString.isPrime(input);
      Assert.assertEquals(String.format("The result should be %b for the input string \"%s\"\n",
        expected, input), expected, actual);
    }
  }
}
