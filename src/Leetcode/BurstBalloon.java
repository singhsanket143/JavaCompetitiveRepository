package Leetcode;

public class BurstBalloon {
    // https://leetcode.com/problems/burst-balloons/
    public int maxCoins(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[][] dp = new int[n][n];
        for (int len = 1; len <= n; len++) {
            for (int left = 0; left <= n - len; left++) {
                int right = left + len - 1;
                for (int k = left; k <= right; k++) {
                    int left_part = (k - 1 < 0) ? 0 : dp[left][k - 1];
                    int right_part = (k + 1 >= n) ? 0 : dp[k + 1][right];
                    int left_mult = (left - 1 < 0) ? 1 : nums[left - 1];
                    int right_mult = (right + 1 >= n) ? 1 : nums[right + 1];
                    dp[left][right] = Math.max(dp[left][right], left_part + right_part + left_mult * nums[k] * right_mult);
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {

    }
}
