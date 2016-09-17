package com.sword;

import java.util.Arrays;

/**
 * Created by 诚 on 2016/9/10.
 * 找出最小旋转数组
 */
public class MinNumRotate {
    public static int minNumberInRotateArray(int [] array) {
        if (array == null || array.length <= 0)
            return 0;
        Arrays.sort(array);
        return array[0];
    }

    public static void main(String[] args) {
        int i = minNumberInRotateArray(new int[]{3});
        System.out.println(i);
    }
}
