package com.video.stackandqueue;

import java.util.Stack;

/**
 * Created by hexi on 17-1-29.
 */
public class TwoStack {

    private final Stack<Integer> pushStack = new Stack<>();
    private final Stack<Integer> popStack = new Stack<>();

    public int[] twoStack(int[] ope, int n) {
        int len = 0;
        for (int i : ope) {
            if (i == 0)
                len++;
        }
        int[] res = new int[len];
        int j = 0;
        for (int i = 0; i < ope.length; i++) {
            if (ope[i] != 0) {
                pushStack.push(ope[i]);
            } else {
                while (!pushStack.isEmpty())
                    popStack.push(pushStack.pop());
                res[j++] = popStack.pop();
                while (!popStack.isEmpty())
                    pushStack.push(popStack.pop());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TwoStack t = new TwoStack();
        int[] ints = t.twoStack(new int[]{1, 2, 3, 0, 4, 0}, 6);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
