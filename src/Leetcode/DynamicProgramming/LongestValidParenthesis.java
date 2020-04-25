package Leetcode.DynamicProgramming;

import java.util.Arrays;

public class LongestValidParenthesis {
    public int longestValidParentheses(String s) {
        int n = s.length();
        if (n <= 1) return 0;
        int[] dp = new int[n];
        dp[0] = 0;
        char ch = s.charAt(1);
        if (ch == ')' && s.charAt(0) == '(') dp[1] = 2;
        else dp[1] = 0;
        for (int i = 2; i < n; i++) {
            ch = s.charAt(i);
            if (ch == '(') dp[i] = 0;
            else {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = dp[i - 2] + 2;
                } else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 + ((i - dp[i - 1] - 2 >= 0) ? dp[i - dp[i - 1] - 2] : 0);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {

    }
}
