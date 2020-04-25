package Leetcode.DynamicProgramming;

public class CountingBits {
    // https://leetcode.com/problems/counting-bits/

    public int[] countBits(int num) {
        int n = num;
        int[] result = new int[n+1];
        int power = 1;
        int count = 0;
        for(int i = 1; i <= num; i++) {
            result[i] = result[i >> 1] + (i%2);
        }
        return result;
    }
    public static void main(String[] args) {

    }
}
