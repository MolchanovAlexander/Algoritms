package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

public class AddTwoNumbersTest {
  @BeforeAll
  public static void setUp(){

  }

  @Test
  public void addTwoNumbers_oneDigitNumbers() {
    Node list1 = new Node(5);
    Node list2 = new Node(3);
    Node expectedList = new Node(8);
    String list1String = convertListToString(list1);
    String list2String = convertListToString(list2);
    String expectedString = convertListToString(expectedList);
    Assert.assertEquals(String.format("The result should be \"%s\" for the linked lists \"%s\" and \"%s\"\n",
      expectedString, list1String, list2String), expectedString, convertListToString(AddTwoNumbers.addTwoNumbers(list1, list2)));
  }

  @Test
  public void addTwoNumbers_bigOneDigitNumbers() {
    Node list1 = new Node(9);
    Node list2 = new Node(7);
    Node expectedList = new Node(6, new Node(1));
    String list1String = convertListToString(list1);
    String list2String = convertListToString(list2);
    String expectedString = convertListToString(expectedList);
    Assert.assertEquals(String.format("The result should be \"%s\" for the linked lists \"%s\" and \"%s\"\n",
      expectedString, list1String, list2String), expectedString, convertListToString(AddTwoNumbers.addTwoNumbers(list1, list2)));
  }

  @Test
  public void addTwoNumbers_twoDigitNumbers() {
    Node list1 = new Node(5, new Node(3));
    Node list2 = new Node(8, new Node(2));
    Node expectedList = new Node(3, new Node(6));
    String list1String = convertListToString(list1);
    String list2String = convertListToString(list2);
    String expectedString = convertListToString(expectedList);
    Assert.assertEquals(String.format("The result should be \"%s\" for the linked lists \"%s\" and \"%s\"\n",
      expectedString, list1String, list2String), expectedString, convertListToString(AddTwoNumbers.addTwoNumbers(list1, list2)));
  }

  @Test
  public void addTwoNumbers_bigTwoDigitNumbers() {
    Node list1 = new Node(8, new Node(8));
    Node list2 = new Node(1, new Node(7));
    Node expectedList = new Node(9, new Node(5, new Node(1)));
    String list1String = convertListToString(list1);
    String list2String = convertListToString(list2);
    String expectedString = convertListToString(expectedList);
    Assert.assertEquals(String.format("The result should be \"%s\" for the linked lists \"%s\" and \"%s\"\n",
      expectedString, list1String, list2String), expectedString, convertListToString(AddTwoNumbers.addTwoNumbers(list1, list2)));
  }

  @Test
  public void addTwoNumbers_threeDigitNumbers() {
    Node list1 = new Node(1, new Node(2, new Node(3)));
    Node list2 = new Node(2, new Node(4, new Node(6)));
    Node expectedList = new Node(3, new Node(6, new Node(9)));
    String list1String = convertListToString(list1);
    String list2String = convertListToString(list2);
    String expectedString = convertListToString(expectedList);
    Assert.assertEquals(String.format("The result should be \"%s\" for the linked lists \"%s\" and \"%s\"\n",
      expectedString, list1String, list2String), expectedString, convertListToString(AddTwoNumbers.addTwoNumbers(list1, list2)));
  }

  @Test
  public void addTwoNumbers_bigThreeDigitNumbers() {
    Node list1 = new Node(9, new Node(8, new Node(9)));
    Node list2 = new Node(4, new Node(9, new Node(6)));
    Node expectedList = new Node(3, new Node(8, new Node(6, new Node(1))));
    String list1String = convertListToString(list1);
    String list2String = convertListToString(list2);
    String expectedString = convertListToString(expectedList);
    Assert.assertEquals(String.format("The result should be \"%s\" for the linked lists \"%s\" and \"%s\"\n",
      expectedString, list1String, list2String), expectedString, convertListToString(AddTwoNumbers.addTwoNumbers(list1, list2)));
  }

  @Test
  public void addTwoNumbers_numbersOfDifferentSizes() {
    Node list1 = new Node(6, new Node(2, new Node(7)));
    Node list2 = new Node(1, new Node(5, new Node(8, new Node(3))));
    Node expectedList = new Node(7, new Node(7, new Node(5, new Node(4))));
    String list1String = convertListToString(list1);
    String list2String = convertListToString(list2);
    String expectedString = convertListToString(expectedList);
    Assert.assertEquals(String.format("The result should be \"%s\" for the linked lists \"%s\" and \"%s\"\n",
      expectedString, list1String, list2String), expectedString, convertListToString(AddTwoNumbers.addTwoNumbers(list1, list2)));
  }

  @Test
  public void addTwoNumbers_twoZeroes() {
    Node list1 = new Node(0);
    Node list2 = new Node(0);
    Node expectedList = new Node(0);
    String list1String = convertListToString(list1);
    String list2String = convertListToString(list2);
    String expectedString = convertListToString(expectedList);
    Assert.assertEquals(String.format("The result should be \"%s\" for the linked lists \"%s\" and \"%s\"\n",
      expectedString, list1String, list2String), expectedString, convertListToString(AddTwoNumbers.addTwoNumbers(list1, list2)));
  }

  private static String convertListToString(Node list) {
    StringBuilder sb = new StringBuilder();
    while (list != null) {
      sb.append(list.getData()).append(" -> ");
      list = list.getNext();
    }
    return sb.append("null").toString().substring(0, sb.length() - 8);
  }
}
