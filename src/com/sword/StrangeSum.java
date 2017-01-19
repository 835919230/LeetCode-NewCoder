package com.sword;

/**
 * Created by HeXi on 2017/1/19.
 */
public class StrangeSum {
    public static int Sum_Solution(int n) {
        int ans = n;
        boolean b = (ans > 0) && (ans += Sum_Solution(n - 1)) > 0;
        return ans;
    }

    public static void main(String[] args) {
        int sum = Sum_Solution(100);
        System.out.println(sum);
    }
}
