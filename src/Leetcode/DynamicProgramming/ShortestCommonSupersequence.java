package Leetcode.DynamicProgramming;

public class ShortestCommonSupersequence {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        if (n == 0) return str2;
        if (m == 0) return str1;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        String str = "";
        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                str += str1.charAt(i - 1);
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                str += str1.charAt(i - 1);
                i--;
            } else {
                str += str2.charAt(j - 1);
                j--;
            }
        }
        while (i > 0) {
            str += str1.charAt(i - 1);
            i--;
        }
        while (j > 0) {
            str += str2.charAt(j - 1);
            j--;
        }
        return new StringBuilder(str).reverse().toString();
    }

    public static void main(String[] args) {

    }
}
