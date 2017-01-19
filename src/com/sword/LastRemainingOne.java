package com.sword;

import java.util.ArrayList;

/**
 * Created by HeXi on 2017/1/19.
 */
public class LastRemainingOne {
    public static int LastRemaining_Solution(int n, int m) {
        if (n == 0)
            return -1;
        if (n == 1)
            return 0;
        else return (LastRemaining_Solution(n - 1, m) + m) % n;
    }

    public static int lastRemaining(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = -1;
        while (list.size() > 1) {
            index = (index + m) % list.size();
            list.remove(index);
            index--;
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        int i = LastRemaining_Solution(5, 3);
        System.out.println(i);

        System.out.println(lastRemaining(5, 3));
    }
}
