package Leetcode.DynamicProgramming;

public class KnightProbability {
    // https://leetcode.com/problems/knight-probability-in-chessboard/
    public double knightProbability(int N, int k, int r, int c) {
        int[] dr = new int[]{2, 2, 1, 1, -1, -1, -2, -2};
        int[] dc = new int[]{1, -1, 2, -2, 2, -2, 1, -1};
        double[][] prev = new double[N][N];
        double[][] curr;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                prev[i][j] = 1.0;
            }
        }

        for(int m = 1; m <= k; m++) {
            curr = new double[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    for(int d = 0; d < 8; d++) {
                        int cr = i + dr[d];
                        int cc = j + dc[d];
                        if(cr >= 0 && cc >= 0 && cr < N && cc < N) {
                            curr[i][j] += prev[cr][cc]/8.0;
                        }
                    }
                }
            }
            prev = curr;
        }
        return prev[r][c];
    }
    public static void main(String[] args) {

    }
}
