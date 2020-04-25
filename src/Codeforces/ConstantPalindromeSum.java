package Codeforces;

import java.util.Scanner;

public class ConstantPalindromeSum {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0) {
            int n = scn.nextInt();
            int k = scn.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = scn.nextInt();
            }
            int maxSum = Integer.MIN_VALUE;
            int minSum = Integer.MAX_VALUE;
            int lo = 0, hi = n-1;
            while(lo <= hi) {
                minSum = Math.min(minSum, arr[lo] + arr[hi]);
                maxSum = Math.max(maxSum, arr[lo] + arr[hi]);
                lo++;
                hi--;
            }
            if(minSum == maxSum) {
                System.out.println(0);
                continue;
            }
            lo = 0; hi = n-1;
            int count = 0;
            System.out.println(minSum);
            while(lo <= hi) {
                if(arr[hi] + arr[lo] == minSum) {
                    lo++;
                    hi--;
                    continue;
                }
                arr[hi] = minSum - arr[lo];
                count++;
                lo++;
                hi--;
            }
            System.out.println(count);
        }
    }
}
