package com.leetcode.twopointer;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口解最小覆盖子串
 */
public class No76 {
    // TODO: 2022/2/12 未弄清楚...
    public String minWindow(String s, String t) {
        //把t中的字符全部放到map中
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        int left = 0;//窗口的左边界
        int right = 0;//窗口的右边界

        //满足条件的窗口开始位置
        int strStart = 0;
        //满足条件的窗口的长度
        int windowLength = Integer.MAX_VALUE;

        while (right < s.length()) {
            //记录右指针扫描过的字符
            char rightChar = s.charAt(right);
            //如果右指针扫描的字符存在于map中，就减1
            if (map.containsKey(rightChar))
                map.put(rightChar, map.getOrDefault(rightChar, 0) - 1);
            //记录之后右指针要往右移
            right++;

            //检查窗口是否把t中字符全部覆盖了，如果覆盖了，要移动窗口的左边界
            //找到最小的能全部覆盖的窗口
            while (check(map)) {
                //如果现在窗口比之前保存的还要小，就更新窗口的长度
                //以及窗口的起始位置
                if (right - left < windowLength) {
                    windowLength = right - left;
                    strStart = left;
                }
                //移除窗口最左边的元素，也就是缩小窗口
                char leftChar = s.charAt(left);
                if (map.containsKey(leftChar))
                    map.put(leftChar, map.getOrDefault(leftChar, 0) + 1);
                //左指针往右移
                left++;
            }
        }
        //如果找到合适的窗口就截取，否则就返回空
        if (windowLength != Integer.MAX_VALUE)
            return s.substring(strStart, strStart + windowLength);
        return "";
    }

    //检查窗口是否把字符串t中的所有字符都覆盖了，如果map中所有
    // value的值都不大于0，则表示全部覆盖
    private boolean check(Map<Character, Integer> map) {
        for (int value : map.values()) {
            //注意这里的value是可以为负数的，为负数的情况就是，相同的字符右
            // 指针扫描的要比t中的多，比如t是"ABC"，窗口中的字符是"ABBC"
            if (value > 0)
                return false;
        }
        return true;
    }
}
