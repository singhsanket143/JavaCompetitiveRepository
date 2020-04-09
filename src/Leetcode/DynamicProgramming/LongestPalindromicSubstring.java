package Leetcode.DynamicProgramming;

public class LongestPalindromicSubstring {
    //    https://leetcode.com/problems/longest-palindromic-substring/
    public String longestPalindrome(String s) {
        int lower = 0, higher = 0;
        int n = s.length();
        if (n == 0) return "";
        for (int i = 1; i < n; i++) {
            int lo = i - 1, hi = i;
            while (lo >= 0 && hi < n) {
                if (s.charAt(lo) == s.charAt(hi)) {
                    lo--;
                    hi++;
                } else {
                    break;
                }
            }
            if (hi - lo - 2 > higher - lower) {
                lower = lo + 1;
                higher = hi - 1;
            }
        }
        int lower1 = 0, higher1 = 0;
        for (int i = 1; i < n; i++) {
            int lo = i - 1, hi = i + 1;
            while (lo >= 0 && hi < n) {
                if (s.charAt(lo) == s.charAt(hi)) {
                    lo--;
                    hi++;
                } else {
                    break;
                }
            }
            if (hi - lo - 2 > higher1 - lower1) {
                lower1 = lo + 1;
                higher1 = hi - 1;
            }
        }
        if (higher - lower > higher1 - lower1) {
            return s.substring(lower, higher + 1);
        } else {
            return s.substring(lower1, higher1 + 1);
        }
    }

    public static void main(String[] args) {

    }
}
