package Leetcode.DynamicProgramming;

import java.util.ArrayList;
import java.util.Scanner;

public class MatrixChainMultiplication {
    public static int matrixMultiply(ArrayList<Integer> arr) {
        int n = arr.size();
        int[][] dp = new int[n-1][n-1];
        for(int len = 2; len < n; len++) {
            for(int i = 0; i < n - len ; i++) {
                int j = i + len - 1;
                dp[i][j]=Integer.MAX_VALUE;
                for(int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + arr.get(i)*arr.get(k+1)*arr.get(j+1));
                }
            }
        }
        return dp[0][n-2];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int x = scn.nextInt();
            arr.add(x);
        }
        System.out.println(matrixMultiply(arr));
    }
}
