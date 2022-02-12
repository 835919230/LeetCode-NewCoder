package com.leetcode.bfsdfs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 子串拆分，wordDict是给定集合，能否拆成集合中的子串（不是子序列）
 */
public class No139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, 0, new HashSet<>());
    }

    private boolean dfs(String s, List<String> wordDict, int start, Set<Integer> idxSet) {
        if (start == s.length()) {
            return true;
        }
        for (int i = start + 1; i <= s.length(); i++) {
            if (idxSet.contains(i)) {
                continue;
            }
            if (wordDict.contains(s.substring(start, i))) {
                if (dfs(s, wordDict, i, idxSet)) {
                    return true;
                }

                idxSet.add(i);
            }
        }
        return false;
    }
}
