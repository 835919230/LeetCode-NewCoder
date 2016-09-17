package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 诚 on 2016/9/7.
 * @see @link https://leetcode.com/problems/two-sum/
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int pre = target - nums[i];
            if (map.containsKey(nums[i])) {
                Integer idx = map.get(nums[i]);
                return new int[] {idx,i};
            }
            map.put(pre,i);
        }
        return new int[]{0,0};
    }

    public static void main(String[] args) {
//        int[] nums = {2,7,11,15};int target = 9;
//
//        int[] ints = new TwoSum().twoSum(nums, target);
//        for (int i : ints) System.out.print(i);
        int i = 5;
        int j = 10;
        System.out.println(i+~j);
    }
}
