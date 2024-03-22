package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

class RevealCards {
  public static int[] deckRevealedIncreasing(int[] deck) {
    LinkedList<Integer> linkedList = new LinkedList<>();
    Arrays.sort(deck);
    for (int i = deck.length - 1;i >= 0;i--) {   
      linkedList.add(deck[i]);
      if (i == 0) {
        Collections.reverse(linkedList);
        break;
      }
        linkedList.add(linkedList.getFirst());
        linkedList.removeFirst();
    }
    return linkedList.stream().mapToInt(i -> i).toArray();
  }
}

/* input - output
 @BeforeClass
    public static void setup() {
        data.put(new int[]{17, 13, 11, 2, 3, 5, 7}, new int[]{2, 13, 3, 11, 5, 17, 7});
        data.put(new int[]{1, 1000}, new int[]{1, 1000});
        data.put(new int[]{2, 3, 5}, new int[]{2, 5, 3});
        data.put(new int[]{6, 4, 2}, new int[]{2, 6, 4});
        data.put(new int[]{1, 2, 3, 4, 5}, new int[]{1, 5, 2, 4, 3});
        data.put(new int[]{8, 1, 7}, new int[]{1, 8, 7});
    }
 */