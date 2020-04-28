package Leetcode.DynamicProgramming;

import java.util.Arrays;

public class targetSum {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = Arrays.stream(nums).sum();
        int n = nums.length;
        int[][] dp = new int[n][2000+5];
        if(S > 1000) return 0;
        dp[0][nums[0] + 1000] = 1;
        dp[0][-nums[0] + 1000] += 1;
        for(int i = 1; i < n; i++) {
            for(int j = -1000; j <= 1000; j++) {
                if(j-nums[i]+1000 >=0) {
                    dp[i][j+1000] += dp[i-1][j-nums[i]+1000];
                }
                if(j+nums[i]+1000 <=2004) {
                    dp[i][j+1000] += dp[i-1][j+nums[i]+1000];
                }
            }
        }
        return dp[n-1][S+1000];
    }
    public static void main(String[] args) {

    }
}
