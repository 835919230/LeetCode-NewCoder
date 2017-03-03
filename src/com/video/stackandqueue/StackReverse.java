package com.video.stackandqueue;

import java.util.Stack;

/**
 * Created by hexi on 17-1-29.
 */
public class StackReverse {
    private final Stack<Integer> stack = new Stack<Integer>();

    public int[] reverseStack(int[] A, int n) {
        for (int i : A) {
            stack.push(i);
        }
        int last = process(stack);
        stack.push(last);
        for (int i = 0; i < A.length; i++) {
            A[i] = stack.pop();
        }
        return A;
    }

    private int process(Stack<Integer> stack) {
        int res = stack.pop();
        if (stack.isEmpty()) {
            return res;
        } else {
            int last = process(stack);
            stack.push(last);
            return res;
        }
    }

    public static void main(String[] args) {
        StackReverse stackReverse = new StackReverse();
        int[] ints = stackReverse.reverseStack(new int[]{4, 3, 2, 1}, 4);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
