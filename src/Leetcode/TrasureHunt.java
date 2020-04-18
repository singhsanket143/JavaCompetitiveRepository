package Leetcode;

import java.util.Scanner;

public class TrasureHunt {
    static boolean isValid(int x, int y1, int y2, int R, int C) {
        return (x >= 0 && x < R && y1 >= 0 && y1 < C && y2 >= 0 && y2 < C);
    }

    static int helper(int arr[][], int mem[][][],
                          int x, int y1, int y2) {
        int R = arr.length;
        int C = arr[0].length;
        if (!isValid(x, y1, y2, R, C)) return Integer.MIN_VALUE;
        if (x == R - 1 && y1 == 0 && y2 == C - 1)
            return (y1 == y2) ? arr[x][y1] : arr[x][y1] + arr[x][y2];
        if (x == R - 1) return Integer.MIN_VALUE;
        if (mem[x][y1][y2] != -1) return mem[x][y1][y2];
        int ans = Integer.MIN_VALUE;
        int temp = (y1 == y2) ? arr[x][y1] : arr[x][y1] + arr[x][y2];
        ans = Math.max(ans, temp + helper(arr, mem, x + 1, y1, y2 - 1));
        ans = Math.max(ans, temp + helper(arr, mem, x + 1, y1, y2 + 1));
        ans = Math.max(ans, temp + helper(arr, mem, x + 1, y1, y2));
        ans = Math.max(ans, temp + helper(arr, mem, x + 1, y1 - 1, y2));
        ans = Math.max(ans, temp + helper(arr, mem, x + 1, y1 - 1, y2 - 1));
        ans = Math.max(ans, temp + helper(arr, mem, x + 1, y1 - 1, y2 + 1));
        ans = Math.max(ans, temp + helper(arr, mem, x + 1, y1 + 1, y2));
        ans = Math.max(ans, temp + helper(arr, mem, x + 1, y1 + 1, y2 - 1));
        ans = Math.max(ans, temp + helper(arr, mem, x + 1, y1 + 1, y2 + 1));
        return (mem[x][y1][y2] = ans);
    }

    static int trasure(int arr[][]) {
        int R = arr.length;
        int C = arr[0].length;
        int[][][] mem = new int[R][C][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                for (int l = 0; l < C; l++)
                    mem[i][j][l] = -1;
            }
        }
        return helper(arr, mem, 0, 0, C - 1);
    }


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        System.out.println(trasure(arr));
    }
}
