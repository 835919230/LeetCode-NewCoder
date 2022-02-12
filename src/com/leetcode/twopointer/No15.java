package com.leetcode.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和为0的组合
 */
public class No15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int target = -nums[i];
            int right = nums.length - 1;
            if (nums[i] > 0) {
                break;
            }
            while (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[right]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return list;
    }
}
