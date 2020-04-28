package Leetcode.DynamicProgramming;

public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for(int i = 1; i < n; i++) {
            dp[i] =dp[i-1] + nums[i];
        }
        for(int i = 0 ; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                int sum = dp[j] - dp[i] + nums[i];
                if(k == 0) {
                    if(sum == 0) return true;
                } else if (sum%k == 0) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
