package com.sword;

/**
 * Created by HeXi on 2017/1/18.
 */
public class FindGreatestSumOfSubArray {
    static class Solution {
        public int FindGreatestSumOfSubArray(int[] array) {
            if (array == null || array.length <= 0)
                return 0;
            int curSum = 0;
            int maxSum = Integer.MIN_VALUE;
            for (int i = 0; i < array.length; i++) {
                if (curSum <= 0)
                    curSum = array[i];
                else
                    curSum+=array[i];
                if (curSum > maxSum)
                    maxSum = curSum;
            }

            return maxSum;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.FindGreatestSumOfSubArray(new int[]{6, -3, -2, 7, -15, 1, 2, 2});
        System.out.println(i);
    }
}
