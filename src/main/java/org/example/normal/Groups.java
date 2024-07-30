package org.example.normal;

import java.util.ArrayList;

public class Groups {
    public static void main(String[] args) {
        System.out.println(isValid("{{[()]}}([()])"));
    }

    public static boolean isValid(String string) {
        if (string.isEmpty()) {
            return true;
        }
        char[] chars = string.toCharArray();
        int countF = 0;
        boolean bbb = false;
        String first = Character.toString(chars[0]);
        String opposite = "";

        opposite = getOpposite(first);
        if (opposite == null) return false;
        for (int i = 0; i < chars.length; i++) {
            if (bbb) {
                first = Character.toString(chars[i]);
                opposite = getOpposite(first);
                bbb = false;
                if (opposite == null) {
                    return false;
                }
            }

            System.out.println(i + "____" + countF);

            if (Character.toString(chars[i]).equals(first)) {
                countF++;
            }
            if (Character.toString(chars[i]).equals(opposite)) {
                countF--;
            }
            if (countF == 0) {
                bbb = true;
            }
        }
        return countF > 0 ? false : true;
    }

    private static String getOpposite(String first) {
        System.out.println(first + " mmmm");
        String opposite;
        switch (first) {
            case "(" -> opposite = ")";
            case "[" -> opposite = "]";
            case "{" -> opposite = "}";
            default -> {
                return null;
            }
        }
        return opposite;
    }
}
/* mentors
import java.util.Stack;

public class Groups {
  public static boolean isValid(String string) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < string.length(); i++) {
      if (string.charAt(i) == ']') {
        if (stack.empty() || !stack.peek().equals('[')) {
          return false;
        }
        stack.pop();
      } else if (string.charAt(i) == ')') {
        if (stack.empty() || !stack.peek().equals('(')) {
          return false;
        }
        stack.pop();
      } else if (string.charAt(i) == '}') {
        if (stack.empty() || !stack.peek().equals('{')) {
          return false;
        }
        stack.pop();
      } else {
        stack.push(string.charAt(i));
      }
    }
    return stack.empty();
  }
}

 */
