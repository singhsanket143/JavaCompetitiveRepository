package Leetcode.DynamicProgramming;

public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        if(n == 0 || n == 1) return n;
        int[][] dp = new int[n][n];
        for(int i = 0 ; i < n; i++) {
            dp[i][i] = 1;
        }
        for(int len = 2; len <= n; len++) {
            for(int i = 0 ; i <= n - len; i++) {
                int j = i + len - 1;
                if(len == 2) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) ? 2 : 1;
                } else {
                    if(s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i+1][j-1];
                        dp[i][j]+=2;
                    } else {
                        dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                    }
                }
            }
        }
        return dp[0][n-1];
    }
    public static void main(String[] args) {

    }
}
