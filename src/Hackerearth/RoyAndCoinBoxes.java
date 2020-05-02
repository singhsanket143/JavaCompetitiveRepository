package Hackerearth;

import java.util.Scanner;

public class RoyAndCoinBoxes {
//    https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/practice-problems/algorithm/roy-and-coin-boxes-1/

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[] start = new int[n+1];
        int[] end = new int[n+1];
        int a, b;
        while(m-- > 0) {
            a = scn.nextInt();
            b = scn.nextInt();
            start[a]++;
            end[b]++;
        }
        int[] coins = new int[n+1];
        coins[1] = start[1];
        for(int i = 2; i <= n; i++) {
            coins[i] = start[i] - end[i-1] + coins[i-1];
        }
        int[] dp = new int[10000001];
        for(int i = 0; i < coins.length; i++) {
            dp[coins[i]]++;
        }
        for(int i = dp.length - 2; i >= 0; i--) {
            dp[i] += dp[i+1];
        }
        int q = scn.nextInt();
        while(q-- > 0) {
            int x = scn.nextInt();
            System.out.println(dp[x]);
        }
    }
}
