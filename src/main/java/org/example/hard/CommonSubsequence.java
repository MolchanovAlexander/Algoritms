package org.example.hard;

public class CommonSubsequence {
    public static String getLongestCommonSubsequence(String string1, String string2) {
        System.out.println(string1 + " -1 2- " + string2);
        StringBuilder stb = new StringBuilder();

        char[] smallerStr = string1.length() < string2.length() ? string1.toCharArray() : string2.toCharArray();
        char[] longerStr = string1.length() >= string2.length() ? string1.toCharArray() : string2.toCharArray();
        int lastIndex = 0;
        for (int i = 0; i < smallerStr.length; i++) {
            for (int j = lastIndex; j < longerStr.length; j++) {
                System.out.println(i + " -if- " + j);
                if (smallerStr[i] == longerStr[j]) {
                    stb.append(longerStr[j]);
                    lastIndex = j + 1;
                    break;
                }
            }
        }
        return stb.toString();
    }
}
/* mentor
public class CommonSubsequence {

  /*
  Dynamic Programming (DP) is a method for solving problems by breaking them down
  into simpler subproblems. It is particularly useful for optimization problems,
  where you seek the best solution among a number of possibilities.
  Longest Common Subsequence (LCS) is a classic problem that can be solved
  using dynamic programming.

public static String getLongestCommonSubsequence(String string1, String string2) {
    int m = string1.length();
    int n = string2.length();

    // `dp[i][j]` will store the length of LCS of `string1[0...i-1]` and `string2[0...j-1]`
    int[][] dp = new int[m + 1][n + 1];

    // Constructing the DP matrix
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            // If current characters match, increment the LCS value from the diagonal left-top cell
            if (string1.charAt(i - 1) == string2.charAt(j - 1)) {
                dp[i][j] = dp[i - 1][j - 1] + 1;
            } else {
                // Otherwise, take the maximum LCS length from the cell above or the cell to the left
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
    }

    // Reconstructing the LCS
    StringBuilder lcs = new StringBuilder();

    // Start from the bottom-right corner and work our way up and left
    for (int i = m, j = n; i > 0 && j > 0; ) {
        if (string1.charAt(i - 1) == string2.charAt(j - 1)) {
            // If characters match, they're part of the LCS. Add to the result and move diagonally up-left.
            lcs.append(string1.charAt(i - 1));
            i--;
            j--;
        } else if (dp[i - 1][j] > dp[i][j - 1]) {
            // If the cell above has a larger value, move up
            i--;
        } else {
            // Otherwise, move left
            j--;
        }
    }

    // The LCS was constructed in reverse order, so return its reverse
    return lcs.reverse().toString();
}
}

 */