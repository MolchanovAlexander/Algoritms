package org.example;

public class LevenshteinDistance {
    public static int distance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] wordMatrix = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            wordMatrix[i][0] = i;
        }
        for (int j = 1; j <= n; ++j) {
            wordMatrix[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    wordMatrix[i][j] = wordMatrix[i - 1][j - 1];
                } else {
                    int topLeft = wordMatrix[i - 1][j - 1];
                    int top = wordMatrix[i - 1][j];
                    int left = wordMatrix[i][j - 1];
                    wordMatrix[i][j] = Math.min(topLeft, Math.min(left, top)) + 1;
                }
            }
        }
        return wordMatrix[m][n];
    }
}
