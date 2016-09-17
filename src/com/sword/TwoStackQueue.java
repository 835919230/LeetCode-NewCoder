package com.sword;

import java.util.Stack;

/**
 * Created by 诚 on 2016/9/10.
 */
public class TwoStackQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();//尝试用stack2作为临时栈

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while (stack1.size() > 1) {
            stack2.push(stack1.pop());
        }
        int rel = -1;
        if (stack1.size() >= 1)
            rel = stack1.pop();

        while (stack2.size() > 0)
            stack1.push(stack2.pop());
        return rel;
    }

    public static void main(String[] args) {
        TwoStackQueue queue = new TwoStackQueue();
//        queue.push(1);
//        queue.push(2);
//        queue.push(3);
//        System.out.println(queue.pop());
//        System.out.println(queue.pop());
//        queue.push(4);
//        System.out.println(queue.pop());
//        queue.push(5);
//        System.out.println(queue.pop());
//        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}
