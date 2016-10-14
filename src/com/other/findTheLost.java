package com.other;

/**
 * Created by hexi on 16-10-15.
 */
public class findTheLost {
    public static void main(String[] args) {
        int[] a = new int[99];
        for (int i = 0; i < a.length; i++) {
            a[i] = i + 1;
        }
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        int ans = 5050 - sum;
        System.out.println(ans);
    }
}
