package com.sword;

import com.common.ListNode;

import java.util.Stack;

/**
 * Created by 诚 on 2016/9/10.
 */
public class FindKthLinkedList {
    Stack<ListNode> stack = new Stack<>();
    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode node = head;
        while (node != null){
            stack.push(node);
            node = node.next;
        }
        if (k>stack.size())
            return null;
        int i = 0;
        if (k <= 0)
            return null;
        while (i!=k-1){
            stack.pop();
            ++i;
        }
        return stack.pop();
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
        FindKthLinkedList findKthLinkedList = new FindKthLinkedList();
        ListNode node = findKthLinkedList.FindKthToTail(head, 0);
        System.out.println(node.val);
    }
}
