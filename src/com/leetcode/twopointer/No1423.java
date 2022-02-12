package com.leetcode.twopointer;

/**
 * 从两边开始累积的连续点数和，要取出最大的
 */
public class No1423 {
    public int maxScore(int[] cardPoints, int k) {
        int maxWindow = 0, length = cardPoints.length;
        for (int i = 0; i < k; i++) {
            maxWindow += cardPoints[i];
        }

        int curWindow = maxWindow;
        for (int i = length - 1; i >= (length - k); i--) {
            curWindow -= cardPoints[k - (length - i)];
            curWindow += cardPoints[i];
            maxWindow = Math.max(curWindow, maxWindow);
        }
        return maxWindow;
    }
}
