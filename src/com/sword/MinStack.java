package com.sword;

import java.util.Arrays;

/**
 * Created by HeXi on 2017/1/17.
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * @link https://www.nowcoder.com/practice/4c776177d2c04c2494f2555c9fcc1e49?tpId=13&tqId=11173&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 */
public class MinStack {
    static class Solution {
        private int size = 0;
        private double loadFactor = 0.75;
        private static final int DEFAULT_SIZE = 16;

        private int[] elements = new int[DEFAULT_SIZE];
        private int[] minElements = new int[DEFAULT_SIZE];

        private int minVal = Integer.MAX_VALUE;

        private int index = 0;

        public void push(int node) {
            ensureCapacity(index);
            elements[index] = node;
            minVal = minVal > node ? node : minVal;
            minElements[index] = minVal;
            size++;
            index++;
        }

        private void ensureCapacity(int index) {
            if (index < elements.length * loadFactor)
                return;
            int newLength = index;
            newLength <<= 2;
            elements = copyOf(elements, newLength);
            minElements = copyOf(minElements, newLength);
        }

        public void pop() {
            minVal = index >= 2 ? minElements[index - 2] : Integer.MAX_VALUE;
            --index;
            --size;
        }

        public int top() {
            return elements[index-1];
        }

        public int min() {
            return minElements[index-1];
        }

        public int size() {
            return size;
        }

        public static int[] copyOf(int[] original, int newLength) {
            int[] copy = new int[newLength];
            System.arraycopy(original, 0, copy, 0,
                    Math.min(original.length, newLength));
            return copy;
        }
    }

    public static void main(String[] args) {
        Solution stack = new Solution();
        stack.push(3);
        System.out.println("current top : "+stack.top());
        System.out.println("current min : "+stack.min());
        stack.push(4);
        System.out.println("current top : "+stack.top());
        System.out.println("current min : "+stack.min());
        stack.push(2);
        System.out.println("current top : "+stack.top());
        System.out.println("current min : "+stack.min());
        stack.push(3);
        System.out.println("current top : "+stack.top());
        System.out.println("current min : "+stack.min());
        stack.pop();
        System.out.println("--------------------------after pop!");
        System.out.println("current top : "+stack.top());
        System.out.println("current min : "+stack.min());
        stack.pop();
        System.out.println("current top : "+stack.top());
        System.out.println("current min : "+stack.min());
        stack.pop();
        System.out.println("current top : "+stack.top());
        System.out.println("current min : "+stack.min());

        for (int i = 1024; i <= 2048; i++) {
            stack.push(i);
        }
        System.out.println(stack.top());
        System.out.println(stack.min());
        System.out.println(stack.size());
    }
}
