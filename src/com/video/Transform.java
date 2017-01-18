package com.video;

/**
 * Created by HeXi on 2017/1/18.
 * 对于两个字符串A和B，如果A和B中出现的字符种类相同且每种字符出现的次数相同，则A和B互为变形词，请设计一个高效算法，检查两给定串是否互为变形词。
 给定两个字符串A和B及他们的长度，请返回一个bool值，代表他们是否互为变形词。
 测试样例：
 */
public class Transform {
    static class Solution {
        public boolean chkTransform(String str1, int lena, String str2, int lenb) {
            if (str1 == null || str2 == null || str1.length() != str2.length())
                return false;
            char[] chars1 = str1.toCharArray();
            char[] chars2 = str2.toCharArray();
            int[] map = new int[256];
            for (int i = 0; i < chars1.length; i++) {
                map[chars1[i]]++;
            }
            for (int i = 0; i < chars2.length; i++) {
                if (map[chars2[i]]-- == 0)
                    return false;
            }

            return true;
        }
    }
}
