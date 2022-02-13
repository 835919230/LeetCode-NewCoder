package com.leetcode.twopointer;

/**
 * 可以将任意位置的字符替换成另外的字符，最多替换k次，输出包含重复字母的最长子串的长度
 * 滑动窗口解决
 */
public class No424 {
    public int characterReplacement(String s, int k) {
        int length = s.length();
        int left = 0, right = 0;
        int[] map = new int[26];
        int maxSameCount = 0, maxWindow = 0;

        while (right < length) {
            maxSameCount = Math.max(maxSameCount, ++map[s.charAt(right) - 'A']);

            int curWindow = right - left + 1;
            if (k + maxSameCount < curWindow) {
                map[s.charAt(left) - 'A']--;
                left++;
            } else {
                maxWindow = Math.max(maxWindow, curWindow);
            }
            right++;
        }
        return maxWindow;
    }
}
