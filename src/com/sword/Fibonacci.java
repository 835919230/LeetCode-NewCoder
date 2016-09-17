package com.sword;

/**
 * Created by 诚 on 2016/9/10.
 * 计算斐波拉切数列
 */
public class Fibonacci {
    public static int fibonacci(int n) {
        if (n < 0)return 0;
        int size = n >= 2 ? n+1 : 2;
        int[] f = new int[size];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i < size; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(0));
        System.out.println(fibonacci(1));
        System.out.println(fibonacci(2));
        System.out.println(fibonacci(3));
    }
}
