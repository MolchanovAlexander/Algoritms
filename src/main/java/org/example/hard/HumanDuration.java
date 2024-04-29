package org.example.hard;

import java.util.LinkedList;

public class HumanDuration {
    public static String formatDuration(int seconds) {
        System.out.println(seconds);
        if (seconds == 0) {
            return "now";
        }
        int years = seconds / (60 * 60 * 24 * 365);
        seconds %= (60 * 60 * 24 * 365);
        int days = seconds / (60 * 60 * 24);
        seconds %= (60 * 60 * 24);
        int hours = seconds / (60 * 60);
        seconds %= (60 * 60);
        int minutes = seconds / 60;
        seconds %= 60;
        int second = seconds;
        LinkedList<String> list = new LinkedList<>();
        formatTimeUnit("year", years, list);
        formatTimeUnit("day", days, list);
        formatTimeUnit("hour", hours, list);
        formatTimeUnit("minute", minutes, list);
        formatTimeUnit("second", second, list);
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            int last = stb.lastIndexOf(",");
            if (i == list.size() - 1 && list.size() > 1) {
                if (last > 0) {
                    stb.deleteCharAt(stb.lastIndexOf(","));
                    stb.append("and ").append(list.get(i));
                    System.out.println(stb + " ---");
                    stb.deleteCharAt(stb.lastIndexOf(","));
                }
                if (stb.toString().contains("and")) {
                    break;
                }
                stb.append("and ").append(list.get(i));
                stb.deleteCharAt(stb.lastIndexOf(","));
                break;
            }
            stb.append(list.get(i));
            System.out.println(stb + " <<<--->>>");
            if (list.size() == 1) {
                stb.deleteCharAt(stb.lastIndexOf(","));
            }
        }
        System.out.println(stb + " end");
        return stb.toString().trim();
    }

    private static void formatTimeUnit(String unit, int value, LinkedList<String> list) {
        if (value > 0) {
            String format = String.format("%d %s%s, ", value, unit, (value > 1) ? "s" : "");
            if (format.length() > 2) {
                list.addLast(format);
            }
        }
    }
}
/* mentor
public class HumanDuration {
  public static String formatDuration(int seconds) {
    String result = "";
    int[] units = new int[] {31536000, 86400, 3600, 60, 1};
    String[] labels = new String[] {"year", "day", "hour", "minute", "second"};
    if (seconds == 0) {
      return "now";
    }
    for (int i = 0; i < 5; i++) {
      if (seconds >= units[i]) {
        int quantity = seconds / units[i];
        seconds = seconds % units[i];
        result += (result.equals("") ? "" : (seconds == 0 ? " and " : ", "))
          + quantity + " " + labels[i] + (quantity > 1 ? "s" : "");
      }
    }
    return result;
  }
}
*/

