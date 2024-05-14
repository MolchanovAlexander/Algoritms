package org.example;

import org.example.normal.AlphabeticalSubstring;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class AlphabeticalSubstringTest {
  private static final Map<String, String> data = new HashMap<>();

  @BeforeClass
  public static void beforeClass() {
    data.put("a", "a");
    data.put("nnnnn", "nnnnn");
    data.put("abcdefg", "abcdefg");
    data.put("acfhqrstxyz", "acfhqrstxyz");
    data.put("abcdab", "abcd");
    data.put("dddeeghijjhhhvvwxxxyy", "hhhvvwxxxyy");
    data.put("dfghjkghiklmmmoooppp", "ghiklmmmoooppp");
    data.put("stttttukkllmmnfi", "stttttu");
    data.put("adbcaztt", "ad");
    data.put("zxpolkfeda", "z");
    data.put("dfdjfdjlsjlnvnfvndjsdfljfjsd", "djls");
  }

  @Test
  public void getLongestAlphabeticalSubstring_lettersString() {
    for (Map.Entry<String, String> entry : data.entrySet()) {
      String input = entry.getKey();
      String expected = entry.getValue();
      String actual = AlphabeticalSubstring.getLongestAlphabeticalSubstring(input);
      Assert.assertEquals(String.format("The method should return %s for the input string %s\n",
        expected, input), expected, actual);
    }
  }
}
