package Leetcode.DynamicProgramming;

public class CountPalindromicSubstring {
    // https://leetcode.com/problems/palindromic-substrings/
    public int countPalindrome(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int ans = n;
        for (int i = 1; i < n; i++) {
            int lo = i - 1, hi = i;
            while (lo >= 0 && hi < n) {
                if (s.charAt(lo) == s.charAt(hi)) {
                    lo--;
                    hi++;
                    ans++;
                } else {
                    break;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            int lo = i - 1, hi = i + 1;
            while (lo >= 0 && hi < n) {
                if (s.charAt(lo) == s.charAt(hi)) {
                    lo--;
                    hi++;
                    ans++;
                } else {
                    break;
                }
            }

        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
