package com.leetcode.twopointer;

/**
 * 移除重复数字，本地移除，后面的不管
 */
public class No26 {
    public int removeDuplicates(int[] nums) {
        int l = 0, r = 1;
        while (r < nums.length) {
            if (nums[l] != nums[r]) {
                nums[++l] = nums[r];
            }
            r++;
        }
        return ++l;
    }

    public static void main(String[] args) {
        No26 obj = new No26();
        System.out.println(obj.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }
}
