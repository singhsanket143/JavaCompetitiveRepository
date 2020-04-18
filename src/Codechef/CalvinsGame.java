package Codechef;

import java.util.Scanner;

public class CalvinsGame {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int[] front = new int[n];
        if(k < n) {
            front[k] = arr[k];
        }
        for(int i = k + 1; i < n; i++) {
            front[i] = Math.max(front[i-1], front[i-2]) + arr[i];
        }
        int[] back = new int[n];
        back[0] = arr[0];
        back[1] = arr[0] + arr[1];
        for(int i = 2; i < n; i++) {
            back[i] = Math.max(back[i-1], back[i-2]) + arr[i];
        }
        int result = Integer.MIN_VALUE;
        for(int i = k-1; i < n; i++) {
            result = Math.max(result, front[i]+back[i] - arr[i]);
        }
        System.out.println(result);
    }
}
