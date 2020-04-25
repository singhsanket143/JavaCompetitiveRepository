package Codechef.DynamicProgramming;

import java.util.Scanner;

// https://www.codechef.com/JCWR2019/problems/JCWC00#
public class StrangeProblems {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while (t-- > 0) {
            int n = scn.nextInt();
            int k = scn.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scn.nextInt();
            }
            int partition = k;
            //System.out.println(partition);
            long[] dp = new long[n];
            int max_idx = 0;
            int sec_max_idx = -1;
            if (partition >= 0) {
                for(int i = 0; i < partition; i++) {
                    dp[i] = arr[i];
                    if(i == 0) continue;
                    if(dp[i] > dp[max_idx]) {
                        sec_max_idx = (i == 0) ? -1:max_idx;
                        max_idx = i;
                    } else if(sec_max_idx == -1 || dp[i] > dp[sec_max_idx]) {
                        sec_max_idx = i;
                    }
                }
            }
            int start = 0;
            int new_max_idx = max_idx;
            int new_sec_max_idx = sec_max_idx;
            for (int i = partition; i < n; i++) {
                if (i % partition == 0) {
                    max_idx = new_max_idx;
                    sec_max_idx = new_sec_max_idx;
                    new_max_idx = i;
                    new_sec_max_idx = i;
                    start = i;
                }
                if(Math.abs(i - max_idx) == k) {
                    dp[i] = Math.max(dp[i], dp[sec_max_idx] + arr[i]);
                    dp[i] = Math.max(dp[i], dp[max_idx]);
                } else {
                    dp[i] = Math.max(dp[i], dp[max_idx] + arr[i]);
                }
                if(dp[i] > dp[new_max_idx]) {
                    new_sec_max_idx = new_max_idx;
                    new_max_idx = i;
                } else if(dp[i] > dp[new_sec_max_idx]) {
                    new_sec_max_idx = i;
                }
                dp[i] = Math.max(dp[i], 0);
            }
            long result = Long.MIN_VALUE;
            for(int i = start; i < n; i++) {
                result = Math.max(dp[i], result);
            }
            System.out.println(result);
        }
    }
}
