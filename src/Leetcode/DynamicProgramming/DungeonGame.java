package Leetcode.DynamicProgramming;

public class DungeonGame {
    //     https://leetcode.com/problems/dungeon-game
    public int calculate(int curr, int nextRow, int nextCol, int[][] dungeon) {
        if (nextRow >= dungeon.length || nextRow < 0 || nextCol >= dungeon[0].length || nextCol < 0) {
            return Integer.MAX_VALUE;
        }
        int nextVal = dungeon[nextRow][nextCol];
        return Math.max(1, nextVal - curr);
    }

    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        int[][] dp = new int[n][m];
        int minHealth;
        //dp[n-1][m-1] = (dungeon[n-1][m-1] < 0) ? ((-1*dungeon[n-1][m-1])+1) ? 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int right = calculate(dungeon[i][j], i, j + 1, dp);
                int down = calculate(dungeon[i][j], i + 1, j, dp);
                int value = Math.min(right, down);
                if (value == Integer.MAX_VALUE) {
                    minHealth = (dungeon[i][j] > 0) ? 1 : 1 - dungeon[i][j];
                } else {
                    minHealth = value;
                }
                dp[i][j] = minHealth;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[0][0];
    }
}
