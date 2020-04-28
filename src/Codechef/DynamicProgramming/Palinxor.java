package Codechef.DynamicProgramming;
import java.util.Scanner;

public class Palinxor {
    public static long palinArray(String str) {
        int n = str.length();
        String rev = new StringBuilder(str).reverse().toString();
        int MOD = 1000000007;

        long[][] dp = new long[n+1][n+1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; i + j <= n; j++) {
                dp[i][j] += dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
                if(str.charAt(i-1) == rev.charAt(j-1)) {
                    dp[i][j] += 1 + dp[i-1][j-1];
                }
                dp[i][j] = (dp[i][j] + MOD)%MOD;
            }
        }
        long[] result = new long[n];
        int j = n-1;
        long ans = 0;
        for(int i = 1; i <= n; i++) {
            result[i-1] = dp[i-1][j] + 1;
            result[i-1] = ((i%MOD) * (result[i-1]%MOD))%MOD;
            ans^=result[i-1];
            j--;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while (t-- > 0) {
            String str = scn.next();
            System.out.println(palinArray(str));
        }
    }
}
