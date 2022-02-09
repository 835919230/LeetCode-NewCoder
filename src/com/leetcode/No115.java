package com.leetcode;

public class No115 {

    /**
     * 求解公共子序列问题，计算在s的子序列中，t出现的次数；那么s就至少和t一样长 s.length() >= t.length()
     *
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        // 空字符串是所有字符串的子集，初始化
        for (int i = 0;i<t.length();i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i<t.length(); i++) {
            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j) == t.charAt(i)) {
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[t.length()][s.length()];
    }
}
