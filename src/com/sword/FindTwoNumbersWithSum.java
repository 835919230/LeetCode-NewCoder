package com.sword;

import java.util.ArrayList;

/**
 * Created by HeXi on 2017/1/19.
 * 思路是维护两个指标(index),small和big
 */
public class FindTwoNumbersWithSum {
    public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        int small = 0;
        int big = array.length - 1;
        for (; ; ) {
            if (small >= big)
                break;
            int s = array[small] + array[big];
            if (s == sum) {
                list.add(array[small]);
                list.add(array[big]);
                break;
            } else if (s < sum) {
                small++;
            } else {
                big--;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = FindNumbersWithSum(new int[]{1, 2, 4, 7, 11, 15}, 15);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
