package Codechef;

import java.util.Scanner;

public class supw {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (i <= 2) {
                dp[i] = arr[i];
            } else {
                dp[i] = Math.min(Math.min(dp[i - 1], dp[i - 2]), dp[i - 3]) + arr[i];
            }
        }
        System.out.println(Math.min(Math.min(dp[n - 1], dp[n - 2]), dp[n - 3]));
    }
}
