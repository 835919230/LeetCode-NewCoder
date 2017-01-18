package com.sword;

/**
 * Created by HeXi on 2017/1/18.
 *
 */
public class NumberOf1Between1AndN {
    static class Solution {
        // TODO: 2017/1/18 没弄懂...... https://discuss.leetcode.com/topic/18054/4-lines-o-log-n-c-java-python
        public int NumberOf1Between1AndN_Solution(int n) {
            int ones = 0;
            for (long m = 1; m <= n; m *= 10)
                ones += (n/m + 8) / 10 * m + (n/m % 10 == 1 ? n%m + 1 : 0);
            return ones;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int num = solution.NumberOf1Between1AndN_Solution(13);
        System.out.println(num);
    }
}
