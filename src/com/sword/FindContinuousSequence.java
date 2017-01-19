package com.sword;

import java.util.ArrayList;

/**
 * Created by HeXi on 2017/1/19.
 */
public class FindContinuousSequence {
    public static ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        int len = (sum + 1) / 2;
        int small = 1, big = 2;
        while (small <= len) {
            int s = (big - small + 1) * (small + big) / 2;
            if (s == sum) {
                for (int j = small; j <= big; j++) {
                    list.add(j);
                }
                lists.add(list);
                list = new ArrayList<>();
                small++;
            } else if (s < sum) {
                big++;
            } else {
                small++;
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> continuousSequence = findContinuousSequence(9);
        System.out.println(continuousSequence.size());
    }
}
