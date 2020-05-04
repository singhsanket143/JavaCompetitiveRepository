package SPOJ;

import java.util.Scanner;
// https://www.spoj.com/problems/CPCRC1C/
public class SumOfDigits {

    public static long[] getFirstDigit(long n) {
        int numOfDigits = (int)Math.log10(n);
        n = (int)(n / Math.pow(10, numOfDigits));
        long[] arr = {numOfDigits+1, n};
        return arr;
    }
    public static long sumOfDigits(long n) {
        if(n <= 0) return n;
        if(n < 10) return (n)*(n+1)/2;
        long[] retval = getFirstDigit(n);
        long first = retval[1];
        long size = retval[0];
        long result = 0;
        long contri = 1;
        for(int i = 0; i < first; i++) {
            result += i*(long)(Math.pow(10, size-1));
            for(int j = (int)size-2; j >= 0; j--) {
                result += 45*(long)(Math.pow(10, j))*contri;
                contri*=10;
            }
            contri = 1;
        }
        long rem = n%((long)(Math.pow(10, size-1)));
        result += first*(rem+1);
        return result + sumOfDigits(rem);

    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a, b;
        while(true) {
            a = scn.nextInt();
            b = scn.nextInt();
            if(a == -1 && b == -1) return;
            long x = sumOfDigits(b);
            long y = sumOfDigits(a-1);
            System.out.println(x - y);
        }
    }
}
