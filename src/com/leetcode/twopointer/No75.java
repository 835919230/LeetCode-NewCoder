package com.leetcode.twopointer;

/**
 * 三色排序
 */
public class No75 {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                continue;
            }
            if (nums[i] == 0) {
                left++;
            }
            if (nums[i] == 2) {
                right--;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < left) {
                nums[i] = 0;
            } else if (i > right) {
                nums[i] = 2;
            } else {
                nums[i] = 1;
            }
        }
    }
}
