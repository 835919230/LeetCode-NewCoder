package com.sword;

/**
 * Created by HeXi on 2017/1/20.
 */
// TODO: 2017/1/20 不理解 https://www.nowcoder.com/practice/253d2c59ec3e4bc68da16833f79a38e4?tpId=13&tqId=11208&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
public class Match {
    public static boolean match(char[] str, char[] pattern) {
        return false;
    }

    public static boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }

        if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }

        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            if ((strIndex != str.length));
        }

        return false;
    }
}
