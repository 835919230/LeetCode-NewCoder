package com.leetcode.bfsdfs;

/**
 * 搜索给定数字数组的和能否等于target，只允许有 + 或 -
 */
public class No494 {
    int count = 0;
    public int findTargetSumWays(int[] nums, int target) {
        count = 0;
        dfs(nums, 0, target, 0);
        return count;
    }

    private void dfs(int[] nums, int index, int target, int sum) {
        if (index == nums.length) {
            if (target == sum) {
                count++;
            }
            return;
        }
        dfs(nums, index + 1, target, sum + nums[index]);
        dfs(nums, index + 1, target, sum - nums[index]);
    }
}
