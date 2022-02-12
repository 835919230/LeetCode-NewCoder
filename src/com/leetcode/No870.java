package com.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 田忌赛马策略
 */
public class No870 {

    public int[] advantageCount(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        // idx,val；最大堆
        PriorityQueue<int[]> maxQueue = new PriorityQueue<>(((o1, o2) -> Integer.compare(o2[1], o1[1])));
        for (int i = 0; i < nums2.length; i++) {
            maxQueue.add(new int[]{i, nums2[i]});
        }
        Arrays.sort(nums1);
        int right = nums1.length -1;
        int left = 0;
        while (!maxQueue.isEmpty()) {
            int[] pair = maxQueue.poll();
            int idx = pair[0];
            int val = pair[1];

            if (nums1[right] > val) {
                res[idx] = nums1[right--];
            } else {
                res[idx] = nums1[left++];
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
