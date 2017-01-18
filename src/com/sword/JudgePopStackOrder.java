package com.sword;

import java.util.Stack;

/**
 * Created by HeXi on 2017/1/17.
 * 输入两个整数序列，第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 * @link https://www.nowcoder.com/practice/d77d11405cc7470d82554cb392585106?tpId=13&tqId=11174&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 */
public class JudgePopStackOrder {
    static class Solution {
        public boolean IsPopOrder(int [] pushA,int [] popA) {
            if (pushA == null || popA == null || pushA.length == 0 || popA.length == 0)
                return false;
            Stack<Integer> stack = new Stack<>();
            int popIndex = 0;
            for (int i = 0; i < pushA.length; i++) {
                stack.push(pushA[i]);
                while (!stack.empty() && stack.peek() == popA[popIndex]) {
                    stack.pop();
                    popIndex++;
                }
            }
            return stack.empty();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.IsPopOrder(new int[]{1,2,3,4,5,6},new int[]{2,3,4,1,6,5}));
        System.out.println(solution.IsPopOrder(new int[]{1,2,3,4,5,6},new int[]{4,3,2,1,5,6}));
        System.out.println(solution.IsPopOrder(new int[]{1,2,3,4,5,6},new int[]{3,2,4,1,6,5}));
        System.out.println(solution.IsPopOrder(new int[]{1,2,3,4,5,6},new int[]{2,4,3,1,5,6}));
        System.out.println(solution.IsPopOrder(new int[]{1,2,3,4,5},new int[]{4,3,5,1,2}));
    }
}
