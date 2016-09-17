package com.sword;

/**
 * Created by 诚 on 2016/9/10.
 * 找出一个数二进制包含1的个数
 */
public class NumberOfOne {
    public static int num(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n = (n - 1)&n;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(num(-10));
    }
}
