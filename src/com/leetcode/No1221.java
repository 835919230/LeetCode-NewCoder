package com.leetcode;

public class No1221 {

    public int balancedStringSplit(String s) {
        char[] arr = s.toCharArray();
        int left = 0;
        int right = 0;
        int num = 0;
        for (char c : arr) {
            if (c == 'L') {
                left++;
            } else if (c == 'R') {
                right++;
            }
            if (left == right) {
                num++;
            }
        }
        return num;
    }
}
