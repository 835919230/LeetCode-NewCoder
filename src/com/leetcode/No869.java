package com.leetcode;

public class No869 {
    public boolean reorderedPowerOf2(int n) {
        if (n < 0) {
            return false;
        }
        String s = String.valueOf(n);
        char[] arr = s.toCharArray();
        boolean[] visited = new boolean[s.length()];
        return find(arr, 0, 0, visited);
    }

    private boolean find(char[] arr, int index, int cur, boolean[] visited) {
        if (index == arr.length) {
            return powerOfTwo(cur);
        }

        for (int i = 0; i < arr.length; i++) {
            if (cur == 0 && arr[i] == '0') {
                continue;
            }
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            int curNum = cur * 10 + arr[i] - '0';
            if (find(arr, index + 1, curNum, visited)) {
                return true;
            }
            visited[i] = false;
        }
        return false;
    }

    private boolean powerOfTwo(int n) {
        return (n & (n - 1)) == 0;
    }
}
