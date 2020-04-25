package Leetcode.DynamicProgramming;

import java.util.ArrayList;

public class PerfectSquare {
    // https://leetcode.com/problems/perfect-squares/
    public int numSquares(int n) {
        if (n <= 1) return n;
        ArrayList<Integer> sq = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            sq.add(i * i);
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < sq.size(); j++) {
                if (sq.get(j) > i) break;
                dp[i] = Math.min(dp[i], 1 + dp[i - sq.get(j)]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {

    }
}
