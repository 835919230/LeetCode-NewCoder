package com.leetcode;

import java.util.Arrays;

public class No455 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;
        for (int i : s) {
            if (count < g.length && i >= g[count]) {
                count++;
            }
        }
        return count;
    }
}
