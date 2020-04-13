package Leetcode;

public class CoinChange {
    // https://leetcode.com/problems/coin-change/
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int ans = -1;
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (coins[j] > i) continue;
                if (dp[i - coins[j]] == Integer.MAX_VALUE) continue;
                dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
            }
        }
        return (dp[amount] == Integer.MAX_VALUE) ? -1 : dp[amount];
    }

    public static void main(String[] args) {

    }
}
