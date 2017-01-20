package com.sword;

import java.util.Arrays;

/**
 * Created by HeXi on 2017/1/19.
 */
public class StrToIntSolution {
    public static int StrToInt(String str) {
        if (str == null || str.length() == 0 || "".equals(str))
            return 0;
        int sum = 0;
        for (int i = str.length() - 1, idx = 1; i >= 0; i--) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                sum += (c - 48) * idx;
                idx = idx == 1 ? 10 : idx * 10;
            } else if (c == '+' && i == 0) {
                continue;
            } else if (c == '-' && i == 0) {
                sum = -sum;
            } else {
                return 0;
            }
        }
        return sum;
    }

    static int x;

    public static void main(String[] args) {
        System.out.println((int) '0');
        System.out.println((int) '1');
        System.out.println(StrToInt("+2147483647000"));
        System.out.println(StrToInt("1a33"));
        System.out.println(x);
    }
}
