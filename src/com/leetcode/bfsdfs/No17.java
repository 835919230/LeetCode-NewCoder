package com.leetcode.bfsdfs;

import java.util.*;

public class No17 {
    public List<String> letterCombinations(String digits) {
        Map<Character, char[]> digitMap = new HashMap<>();
        digitMap.put('2', new char[]{'a', 'b', 'c'});
        digitMap.put('3', new char[]{'d', 'e', 'f'});
        digitMap.put('4', new char[]{'g', 'h', 'i'});
        digitMap.put('5', new char[]{'j', 'k', 'l'});
        digitMap.put('6', new char[]{'m', 'n', 'o'});
        digitMap.put('7', new char[]{'p', 'q', 'r', 's'});
        digitMap.put('8', new char[]{'t', 'u', 'v'});
        digitMap.put('9', new char[]{'w', 'x', 'y', 'z'});

//        return bfs(digitMap, digits.toCharArray());
        List<String> res = new ArrayList<>();
        dfs(digitMap, 0, "", digits.toCharArray(), res);
        return res;
    }

    private List<String> bfs(Map<Character, char[]> digitMap, char[] digitsArr) {
        String begin = "";
        LinkedList<String> queue = new LinkedList<>();
        queue.add(begin);
        while (!queue.isEmpty() && queue.peek().length() != digitsArr.length) {
            String remove = queue.poll();
            int idx = remove.length();
            char cur = digitsArr[idx];

            char[] chars = digitMap.get(cur);
            for (char c : chars) {
                queue.offer(remove + c);
            }
        }
        return queue;
    }

    /**
     * dfs版本
     *
     * @param digitMap 数字和字母的映射
     * @param index 寻找的层数，第几个数字
     * @param cur 当前或之前已经寻找到的字母组合
     * @param digitsArr 要求解的字母数组
     * @param res 结果
     */
    private void dfs(Map<Character, char[]> digitMap, int index, String cur, char[] digitsArr, List<String> res) {
        if (index == digitsArr.length) {
            res.add(cur);
            return;
        }
        char[] chars = digitMap.get(digitsArr[index]);
        for (char c : chars) {
            dfs(digitMap, index + 1, cur + c, digitsArr, res);
        }
    }

    public static void main(String[] args) {
        No17 obj = new No17();
        System.out.println(obj.letterCombinations("23"));
    }
}
