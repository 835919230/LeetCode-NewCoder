package com.sword;

/**
 * Created by HeXi on 2017/1/18.
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 笔记
 https://www.nowcoder.com/practice/6aa9e04fc3794f68acf8778237ba065b?tpId=13&tqId=11186&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class UglyNumber {
    static class Solution {
        public int GetUglyNumber_Solution(int index) {
            if (index < 7)
                return index;
            int[] res = new int[index];
            res[0] = 1;
            int t2 = 0, t3 = 0, t5 = 0;
            for (int i = 1; i < index; i++) {
                res[i] = min(res[t2] * 2, min(res[t3] * 3, res[t5] * 5));
                if (res[i] == res[t2] * 2) t2++;
                if (res[i] == res[t3] * 3) t3++;
                if (res[i] == res[t5] * 5) t5++;
            }
            return res[index - 1];
        }
        private int min(int a, int b) {
            return a>b?b:a;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.GetUglyNumber_Solution(7);
        System.out.println(i);
    }
}
