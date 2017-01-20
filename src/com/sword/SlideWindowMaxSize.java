package com.sword;

import java.util.ArrayList;

/**
 * Created by HeXi on 2017/1/20.
 */
public class SlideWindowMaxSize {
    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        int left = 0;
        int right = left + size - 1;
        ArrayList<Integer> list = new ArrayList<>();
        if (size <= 0)
            return list;
        while (right < num.length) {
            list.add(getMax(num, left++, right++));
        }
        return list;
    }

    private static int getMax(int[] num, int start, int end) {
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            if (num[i] > max)
                max = num[i];
        }

        return max;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = maxInWindows(new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 3);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
