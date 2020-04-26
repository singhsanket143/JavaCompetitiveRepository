package Codeforces;

import java.util.Scanner;

public class WorkingOut {
    // https://codeforces.com/problemset/problem/429/B
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(), m = scn.nextInt();
        int[][] arr = new int[n+1][m+1];
        for(int i = 1 ; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        int[][][] dp = new int[n+5][m+5][4];
        for(int i = 1 ; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i][j-1][0]) + arr[i][j];
            }
        }
        for(int i = n ; i >= 1; i--) {
            for(int j = m; j >= 1; j--) {
                dp[i][j][1] = Math.max(dp[i+1][j][1], dp[i][j+1][1]) + arr[i][j];
            }
        }
        for(int i = n; i >= 1; i--) {
            for(int j = 1; j <= m; j++) {
                dp[i][j][2] = Math.max(dp[i+1][j][2], dp[i][j-1][2]) + arr[i][j];
            }
        }
        for(int i = 1 ; i <= n; i++) {
            for(int j = m; j >= 1; j--) {
                dp[i][j][3] = Math.max(dp[i-1][j][3], dp[i][j+1][3]) + arr[i][j];
            }
        }
        int ans = 0;
        for(int i = 2; i < n; i++) {
            for(int j = 2; j < m; j++) {
                ans = Math.max(ans, dp[i-1][j][0]+dp[i+1][j][1]+dp[i][j-1][2]+dp[i][j+1][3]);
                ans = Math.max(ans, dp[i][j-1][0]+dp[i][j+1][1]+dp[i+1][j][2]+dp[i-1][j][3]);
            }
        }
        System.out.println(ans);
    }
}
