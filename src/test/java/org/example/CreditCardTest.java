package org.example;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CreditCardTest {
  private static final Map<String, Boolean> data = new HashMap<>();

  @BeforeClass
  public static void beforeClass() {
    data.put("123", false);
    data.put("891", false);
    data.put("1230", true);
    data.put("2121", true);
    data.put("26", true);
    data.put("91", true);
    data.put("92", false);
    data.put("1", false);
    data.put("2626262626262626", true);
    data.put("912030", true);
    data.put("922030", false);
    data.put("4111111111111111", true);
    data.put("8675309", false);
  }

  @Test
  public void isValidCardNumber_creditCardNumber() {
    for (Map.Entry<String, Boolean> entry : data.entrySet()) {
      String input = entry.getKey();
      boolean expected = entry.getValue();
      boolean actual = CreditCard.isValidCardNumber(input);
      Assert.assertEquals(String.format("The method should return %b for the credit card number \"%s\"\n",
        expected, input), expected, actual);
    }
  }
}
