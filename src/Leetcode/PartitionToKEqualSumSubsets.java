package Leetcode;

import java.util.Arrays;

public class PartitionToKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if(sum % k != 0) {
            return false;
        }
        if(k <= 0) return false;
        boolean[] visited = new boolean[n];
        return partition(nums, k, visited, 0, 0, 0, sum/k);
    }

    public boolean partition(int[] nums, int k, boolean[] visited, int si, int curr_sum, int curr_num, int target) {
        if (k == 1) return true;
        if(curr_sum == target && curr_num > 0) return partition(nums, k-1, visited, 0, 0, 0, target);
        for(int i = si; i < nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                if(partition(nums, k, visited, i+1, curr_sum + nums[i], curr_num++, target)) return true;
                visited[i] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
