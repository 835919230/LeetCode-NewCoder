package com.sword;

import com.common.ListNode;

import java.util.Stack;

/**
 * Created by 诚 on 2016/9/10.
 * 反转链表
 */
public class Reversor {
    public ListNode ReverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        if (node == null)
            return null;
        while (node != null){
            stack.push(node);
            node = node.next;
        }
        ListNode newHead = new ListNode(0);
        ListNode cur = null;
        int i = 0;
        while (!stack.isEmpty())
        {
            ListNode popNode = stack.pop();
            if (i==0) {
                newHead.val = popNode.val;
                cur = newHead;
                i++;
            } else {
                ListNode newNode = new ListNode(popNode.val);
                cur.next = newNode;
                cur = cur.next;
            }
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode last = null;
        ListNode head = null;
        for (int i = 1; i <= 5; i++) {
            ListNode node = new ListNode(i);
            if (i != 1)
                last.next = node;
            else head = node;
            last = node;
        }
        Reversor reversor = new Reversor();
        ListNode node = reversor.ReverseList(head);
        while (node != null)
        {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
