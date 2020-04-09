package CrossOver;

import java.util.ArrayList;
import java.util.Scanner;

public class CrossOver {
    public static int[] addNumber(int[] arr) {
        int carry = 0;
        int n = arr.length;
        int sum = (arr[n - 1] + 1);
        arr[n - 1] = sum % 10;
        carry = sum / 10;
        for (int i = n - 2; i >= 0; i--) {
            sum = (arr[i] + carry);
            arr[i] = sum % 10;
            carry = sum / 10;
        }
        int[] result;
        if (carry > 0) result = new int[n + 1];
        else result = new int[n];
        if (carry > 0) {
            result[0] = carry;
            System.arraycopy(arr, 0, result, 1, n);
        } else {
            System.arraycopy(arr, 0, result, 0, n);
        }
        return result;
    }

    public static String[] splitString(String str, int k) {
        ArrayList<String> result = new ArrayList<>();
        String s = "";
        for (int i = 0; i < str.length(); i++) {
            s += str.charAt(i);
            while (s.length() > 1 && s.charAt(0) == '0') {
                s = s.substring(1);
            }
            if (s.length() == k) {
                result.add(s);
                s = "";
            }
        }
        while (s.length() > 1 && s.charAt(0) == '0') {
            s = s.substring(1);
        }
        if (s.length() >= 1) {
            result.add(s);
        }
        return result.toArray(new String[result.size()]);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
//        String str = scn.next();
//        int k = scn.nextInt();
//        String[] result = splitString(str, k);
//        for (String key : result) System.out.println(key);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int[] result = addNumber(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
