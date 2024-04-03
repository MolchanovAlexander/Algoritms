package org.example;

public class Files {
    public static String modifyData(String data, String program, String version) {
        String regExPhone = "\\+1-\\d\\d\\d-\\d\\d\\d-\\d\\d\\d\\d";
        String regexPattern = "\\d+\\.\\d+";
        StringBuilder stringBuilder = new StringBuilder();
        String[] dataArr = data.split(System.lineSeparator());
        for (String s : dataArr) {
            if (s.startsWith("Program")) {
                stringBuilder.append(s, 0, s.indexOf(" "))
                        .append(": ")
                        .append(program).append(" ");
            }
            if (s.startsWith("Author")) {
                stringBuilder.append(s, 0, s.indexOf(" "))
                        .append(" g964").append(" ");
            }
            if (s.startsWith("Phone")) {
                if (s.substring(7).matches(regExPhone)) {
                    stringBuilder.append("Phone: ")
                            .append("+1-503-555-0090").append(" ");
                } else {
                    return "ERROR: VERSION or PHONE";
                }
            }
            if (s.startsWith("Date")) {
                stringBuilder.append(s, 0, 6)
                        .append("2019-01-01").append(" ");
            }
            if (s.startsWith("Version")) {
                if (s.substring(9).matches(regexPattern) && !s.substring(9).equals("2.0")) {
                    stringBuilder.append("Version: ")
                            .append(version);
                } else if (s.substring(9).matches(regexPattern) && s.substring(9).equals("2.0")) {
                    stringBuilder.append(s);
                } else {
                    return "ERROR: VERSION or PHONE";
                }
            }
        }
        System.out.println(stringBuilder);
        return stringBuilder.toString();
    }
}
/* mentor
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Files {
  public static String modifyData(String data, String program, String version) {
    Pattern validPhone = Pattern.compile("(Phone: \\+1-\\d{3}-\\d{3}-\\d{4})\\n");
    Matcher phoneChecker = validPhone.matcher(data);
    Pattern validVersion= Pattern.compile("(Version: \\d+\\.\\d+)\\n");
    Matcher versionChecker = validVersion.matcher(data);
    if ((phoneChecker.find() == false) || (versionChecker.find() == false)) {
      return "ERROR: VERSION or PHONE";
    }
    String phone = "+1-503-555-0090";
    String ver = "";
    String matched = versionChecker.group(1);
    if (matched.equals("Version: 2.0")) {
      ver = "2.0";
    } else {
      ver = version;
    }
    return String.format("Program: %s Author: g964 Phone: %s Date: 2019-01-01 Version: %s", program, phone, ver);
  }
}

 */