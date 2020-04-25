package Codeforces;

import java.util.Scanner;

public class BalancedArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0) {
            int n = scn.nextInt();
            if((n/2)%2!=0) {
                System.out.println("NO");
            } else {
                int[] arr = new int[n];
                int m = n/2;
                int sum_of_even = (m)*(m+1);
                int sum_of_odd = (m-1)*(m-1);
                int r = sum_of_even - sum_of_odd;
                for(int i = 0 ; i < m; i++) {
                    arr[i] = 2*i+2;
                }
                int num = 1;
                for(int i = m; i < n-1; i++) {
                    arr[i] = num;
                    num+=2;
                }
                arr[n-1] = r;
                System.out.println("YES");
                for(int i=0;i<n;i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
            }
        }
    }
}
