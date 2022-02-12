package com.leetcode.twopointer;

import java.util.HashMap;
import java.util.Map;

/**
 * 下标距离小于等于k的相等数字是否存在
 */
public class No219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (indexMap.containsKey(nums[i])) {
                Integer idx = indexMap.get(nums[i]);
                if (Math.abs(idx - i) <= k) {
                    return true;
                }
            }
            indexMap.put(nums[i], i);
        }
        return false;
    }
}
