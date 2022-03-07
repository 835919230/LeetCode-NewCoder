package com.leetcode.backtrack;

import java.util.*;

/**
 * 回溯法求火柴是否能拼成正方形
 */
public class No473 {
    public boolean makesquare(int[] nums) {
        int total = 0;
        for (int n : nums) {
            total += n;
        }
        if (total == 0 || (total % 4 != 0)) {
            return false;
        }
        //先排序
        Arrays.sort(nums);

        return backtrack(nums, nums.length - 1, total / 4, new int[4]);
    }

    private boolean backtrack(int[] nums, int index, int target, int[] size) {
        if (index < 0) {
            return size[0] == size[1] && size[1] == size[2] && size[2] == size[3];
        }
        for (int i = 0; i < size.length; i++) {
            if (size[i] + nums[index] > target) {
                continue;
            }
            size[i] += nums[index];

            if (backtrack(nums, index - 1, target, size)) {
                return true;
            }

            size[i] -= nums[index];
        }
        return false;
    }
}
