package Leetcode;

public class BestTimeToBuyAndSellStock1 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];
        if(n==0) return 0;
        dp[n-1] = prices[n-1];
        for(int i = n - 2; i >= 0; i--) {
            dp[i] = Math.max(prices[i], dp[i+1]);
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 0 ; i < n; i++) {
            ans = Math.max(dp[i] - prices[i], ans);
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
