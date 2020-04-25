package Codeforces;

import java.util.Scanner;

public class Candies {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0) {
            int n = scn.nextInt();
            for(int i = 2; 1<<i < 1000000000; i++) {
                int x = 1<<i;
                if(n%(x - 1) == 0) {
                    System.out.println(n/(x - 1));
                    break;
                }
            }

        }
    }
}
