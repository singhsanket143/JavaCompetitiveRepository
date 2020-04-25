package Codeforces;

import java.util.ArrayList;
import java.util.Scanner;

public class AlternatingSubsequence {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while (t-- > 0) {
            int n = scn.nextInt();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scn.nextInt();
            }
            ArrayList<Long> vals = new ArrayList<>();
            long maxSoFar = arr[0];
            for(int i = 1; i < n; i++) {
                if((arr[i]/Math.abs(arr[i]))*-1 == arr[i-1]/Math.abs(arr[i-1])) {
                    vals.add(maxSoFar);
                    maxSoFar = arr[i];
                } else {
                    maxSoFar = Math.max(arr[i], maxSoFar);
                }
            }
            vals.add(maxSoFar);
            long result = 0;
            for(long x: vals) result+=x;
            System.out.println(result);
        }
    }
}
