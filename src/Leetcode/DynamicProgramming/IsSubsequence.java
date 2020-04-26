package Leetcode.DynamicProgramming;

import java.util.Scanner;

public class IsSubsequence {
    public static boolean helper(String s, String t) {
        int i = 0,  j = 0;
        while(i < s.length() && j < t.length()) {
            if(s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        if(i == s.length()) return true;
        else return false;
    }
    public static boolean isSubsequence(String s, String t) {
        return helper(s, t);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        String t = scn.next();
        System.out.println(isSubsequence(s, t));
    }
}
