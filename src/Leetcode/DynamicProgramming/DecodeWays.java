package Leetcode.DynamicProgramming;

public class DecodeWays {
    public int numDecodings(String s) {
        int n = s.length();
        if(n==0) return 0;
        if(n > 0 && s.charAt(0) == '0') return 0;
        int[] dp = new int[n];
        dp[n-1] = (s.charAt(n-1) == '0') ? 0 : 1;
        if(n-2 >= 0 && s.charAt(n-2) != '0') {
            dp[n-2] = dp[n-1];
            if(Integer.parseInt("" + s.charAt(n-2) + s.charAt(n-1)) <= 26) {
                dp[n-2] += 1;
            }
        }
        for(int i = n-3; i >= 0; i--) {
            if(s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }
            dp[i] = dp[i+1];
            if(i+2 < n && s.charAt(i) != '0' && Integer.parseInt("" + s.charAt(i) + s.charAt(i+1)) <= 26) {
                dp[i] += dp[i+2];
            }
        }
        return dp[0];
    }
    public static void main(String[] args) {

    }
}
