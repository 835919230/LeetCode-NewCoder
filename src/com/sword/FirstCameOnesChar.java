package com.sword;

/**
 * Created by HeXi on 2017/1/18.
 */
public class FirstCameOnesChar {
    static class Solution {
        public int FirstNotRepeatingChar(String str) {
            int[] count = new int[256];
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                count[chars[i]]++;
            }

            for (int i = 0; i < chars.length; i++) {
                if (count[chars[i]] == 1)
                    return i;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.FirstNotRepeatingChar("google"));
    }
}
