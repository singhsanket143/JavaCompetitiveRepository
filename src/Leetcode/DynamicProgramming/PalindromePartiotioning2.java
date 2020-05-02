package Leetcode.DynamicProgramming;

public class PalindromePartiotioning2 {
    public int minCut(String s) {
        int n = s.length();
        if(n==0 || n==1) return 0;
        int[][] dp = new int[n][n];
        boolean[][] isPalindrome = new boolean[n][n];
        for(int i = 0 ; i < n; i++) {
            isPalindrome[i][i] = true;
        }
        for(int len = 2; len <= n; len++) {
            for(int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                boolean compare = s.charAt(i) == s.charAt(j);
                if(len == 2) {
                    isPalindrome[i][j] = compare;
                } else {
                    isPalindrome[i][j] = compare && isPalindrome[i+1][j-1];
                }
                if(isPalindrome[i][j]) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for(int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], 1 + dp[i][k] + dp[k+1][j]);
                    }
                }

            }
        }
        return dp[0][n-1];
    }
    public static void main(String[] args) {

    }
}
