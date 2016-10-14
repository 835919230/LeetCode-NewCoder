package com.other;

/**
 * Created by hexi on 16-10-15.
 * 问题描述：一个无序数组里有99个不重复正整数，范围从1到100，唯独缺少一个整数。如何找出这个缺失的整数？
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
