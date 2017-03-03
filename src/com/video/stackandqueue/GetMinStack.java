package com.video.stackandqueue;

import java.util.Random;
import java.util.Stack;

/**
 * Created by hexi on 17-1-28.
 */
public class GetMinStack {

    private final Stack<Integer> innerStack = new Stack<>();
    private final Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        innerStack.push(node);
        if (minStack.isEmpty())
            minStack.push(node);
        else if (minStack.peek() < node)
            minStack.push(minStack.peek());
        else minStack.push(node);
    }

    public int pop() {
        minStack.pop();
        return innerStack.pop();
    }

    public int top() {
        return innerStack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        GetMinStack s = new GetMinStack();
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            s.push(random.nextInt(10000));
        }

        while (!s.innerStack.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}
