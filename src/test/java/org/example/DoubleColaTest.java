package org.example;

import org.example.hard.DoubleCola;
import org.junit.Assert;
import org.junit.Test;

public class DoubleColaTest {
  @Test
  public void getNthPerson_firstPerson() {
    Assert.assertEquals("Method should return the fisrt name from 'names' if n = 1\n",
      "Alice", DoubleCola.getNthPerson(new String[]{"Alice", "Bob", "Charlie"}, 1));
  }

  @Test
  public void getNthPerson_secondPerson() {
    Assert.assertEquals("Method should return the second name from 'names' if n = 2\n",
      "Bob", DoubleCola.getNthPerson(new String[]{"Alice", "Bob", "Charlie", "David", "Eve"}, 2));
  }

  @Test
  public void getNthPerson_lastPerson() {
    Assert.assertEquals("Method should return the last name from 'names' if n = names.length\n",
      "Frank", DoubleCola.getNthPerson(new String[]{"Alice", "Bob", "Charlie", "David", "Eve", "Frank"}, 6));
  }

  @Test
  public void getNthPerson_lengthPlusOne() {
    Assert.assertEquals("Method should return the first name if n = names.length + 1\n",
      "Harry", DoubleCola.getNthPerson(new String[]{"Harry", "Ron", "Hermione", "Ginny", "Neville", "Luna"}, 7));
  }

  @Test
  public void getNthPerson_lengthPlusTwo() {
    Assert.assertEquals("Method should return the first name if n = names.length + 2\n",
      "Sheldon", DoubleCola.getNthPerson(new String[]{"Sheldon", "Leonard", "Howard", "Radjesh", "Penny", "Bernadette", "Amy"}, 9));
  }

  @Test
  public void getNthPerson_oneTurn() {
    Assert.assertEquals("Method should return the fourth name if names.length = 4 and n = 11\n",
      "Pippin", DoubleCola.getNthPerson(new String[]{"Frodo", "Sam", "Merry", "Pippin"}, 11));
  }

  @Test
  public void getNthPerson_twoTurns() {
    Assert.assertEquals("Method should return the second name if names.length = 5 and n = 23\n",
      "Superman", DoubleCola.getNthPerson(new String[]{"Batman", "Superman", "Spiderman", "Wonderwoman", "Antman"}, 23));
  }

  @Test
  public void getNthPerson_manyTurns() {
    Assert.assertEquals("Method should return the third name if names.length = 5 and n = 110\n",
      "Bart", DoubleCola.getNthPerson(new String[]{"Homer", "Marge", "Bart", "Lisa", "Maggie"}, 110));
  }

  @Test
  public void getNthPerson_largeNumber() {
    Assert.assertEquals("Method should work with a large input\n",
      "Guinevere", DoubleCola.getNthPerson(new String[]{"Arthur", "Merlin", "Morgana", "Guinevere"}, 239483859));
  }
}
