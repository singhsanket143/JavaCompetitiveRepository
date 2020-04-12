package Leetcode;

class Custom {
    public int r;
    public int u;
    public int l;
    public int d;

    public Custom(int r, int u, int l, int d) {
        this.r = r;
        this.u = u;
        this.l = l;
        this.d = d;
    }

    public int getValue() {
        return this.r+this.u+this.l+this.d;
    }
}

public class BombEnemy {
    public static int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        Custom[][] dp = new Custom[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = new Custom(0, 0, 0, 0);
                if (grid[i][j] == 'W') {
                    continue;
                } else {
                    dp[i][j].l = (j == 0? 0 : dp[i][j-1].l)  + (grid[i][j] == 'E' ? 1 : 0);
                    dp[i][j].u += (i == 0? 0 : dp[i-1][j].u)  + (grid[i][j] == 'E' ? 1 : 0);
                }
            }
        }

        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (grid[i][j] == 'W') {
                    continue;
                } else {
                    dp[i][j].r = (j == m-1? 0 : dp[i][j+1].r)  + (grid[i][j] == 'E' ? 1 : 0);
                    dp[i][j].d += (i == n-1? 0 : dp[i+1][j].d)  + (grid[i][j] == 'E' ? 1 : 0);
                    if(grid[i][j] == '0') {
                        ans = Math.max(ans, dp[i][j].getValue());
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        char[][] grid = {{'0', 'E', '0', '0'}, {'E', '0', 'W', 'E'}, {'0', 'E', '0', '0'}};
        System.out.println(maxKilledEnemies(grid));
    }
}
