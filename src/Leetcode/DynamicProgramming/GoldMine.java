package Leetcode.DynamicProgramming;

import java.sql.SQLOutput;

public class GoldMine {
    public static int goldMine(int[][] matrix) {
        int result = Integer.MIN_VALUE;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++) {
            dp[i][m-1] = matrix[i][m-1];
        }
//        for(int  i = 0; i < n; i++) {
//            for(int j = 0; j < m; j++) {
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }
        for(int j = m-2; j >= 0; j--) {
            for(int  i = 0; i < n; i++) {
                int cand1 = (i - 1 >= 0) ? dp[i-1][j+1] : Integer.MIN_VALUE;
                int cand2 = dp[i][j+1];
                int cand3 = (i + 1 < n) ? dp[i+1][j+1] : Integer.MIN_VALUE;
                dp[i][j]  = Math.max(cand1, Math.max(cand2, cand3)) + matrix[i][j];
            }
        }
        for(int i = 0; i < n; i++) {
            result = Math.max(result, dp[i][0]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 1, 5},
                {2, 2, 4, 1},
                {5, 0, 2, 3},
                {0, 6, 1, 2}};
        System.out.println(goldMine(matrix));
    }
}
