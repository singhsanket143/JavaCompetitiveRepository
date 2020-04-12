package Leetcode;

import java.util.Arrays;

public class FindLongestChain {
    // https://leetcode.com/problems/maximum-length-of-pair-chain
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int n = pairs.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
    public static void main(String[] args) {

    }
}
