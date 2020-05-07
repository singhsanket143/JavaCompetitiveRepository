package Leetcode.DynamicProgramming;
import java.util.*;
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer[] dp = new Integer[n];
        if (n == 0) return 0;
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int cand1 = dp[j];
                int cand2 = dp[j + 1];
                dp[j] = triangle.get(i).get(j) + Math.min(cand1, cand2);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
    }
}
