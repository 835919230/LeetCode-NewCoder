package com.leetcode.twopointer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class No3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        int left = 0, right = 1;
        int maxLen = 1;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(left), left);
        while (right < s.length() && left < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                Integer endIdx = map.get(s.charAt(right));
                for (int i = left; i < endIdx + 1; i++) {
                    map.remove(s.charAt(i));
                }
                left = endIdx + 1;
            }
            map.put(s.charAt(right), right);
            maxLen = Math.max(right - left + 1, maxLen);
            right++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        No3 obj = new No3();
        System.out.println(obj.lengthOfLongestSubstring("abba"));
    }
}
