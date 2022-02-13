package com.leetcode.twopointer;

public class No11 {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;

        int ans = Integer.MIN_VALUE;

        while (l < r) {
            int area = Integer.min(height[l], height[r]) * (r - l);

            ans = Integer.max(ans, area);

            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }
}
