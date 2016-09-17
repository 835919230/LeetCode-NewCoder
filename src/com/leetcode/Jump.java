package com.leetcode;

/**
 * Created by 诚 on 2016/9/9.
 */
public class Jump {
    public static int JumpFloor(int target) {
        if (target < 0)
            return 0;

        int size = target + 1 >= 4 ? target + 1 : 4;
        int[] a = new int[size];
        a[0] = 0;
        a[1] = 1;
        a[2] = 2;
        for (int i = 3; i < a.length; i++) {
            a[i] = a[i-1] + a[i-2];
        }

        return a[target];
    }

    public static void main(String[] args) {
//        System.out.println(JumpFloor(2));
        System.out.println(JumpFloor(3));
        System.out.println(JumpFloor(4));
        System.out.println(JumpFloor(0));
    }
}
