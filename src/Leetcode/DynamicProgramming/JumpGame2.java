package Leetcode.DynamicProgramming;

import java.util.ArrayList;
import java.util.Scanner;

public class JumpGame2 {
    public static int jump(ArrayList<Integer> A) {
        int n = A.size();
        int[] dp = new int[n];
        for(int i = n - 2; i >= 0; i--) {
            dp[i] = Integer.MAX_VALUE;
            if(A.get(i) == 0) {
                dp[i] = 0;
                continue;
            }
            for(int j = A.get(i); j>0 && i+j < n; j--) {
                dp[i] = Math.min(dp[i], dp[i+j] + 1);
            }
        }
        for(int i = 0 ; i < n; i++) {
            System.out.println(dp[i]);
        }
        return dp[0];
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int x = scn.nextInt();
            arr.add(x);
        }
        System.out.println(jump(arr));
    }
}
