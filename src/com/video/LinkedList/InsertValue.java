package com.video.LinkedList;

import com.common.ListNode;

/**
 * Created by hexi on 17-1-23.
 */
// TODO: 17-1-23 我觉得我做的是对的
public class InsertValue {
    public ListNode insert(int[] A, int[] nxt, int val) {
        ListNode head = new ListNode(-1);
        ListNode node = head;
        for (int i = 0; i < A.length; i++) {
            ListNode newNode = new ListNode(A[i]);
            node.next = newNode;
            node = node.next;
        }
        node.next = head.next;
        node = head.next;
        ListNode cur = head.next;
        if (cur == null)
            return head.next;
        ListNode next = head.next.next;
        if (next == null) {
            ListNode newNode = new ListNode(val);
            cur.next = newNode;
            newNode.next = next;
        }
        for (; ; ) {
            if (cur.val <= val && val <= next.val) {
                ListNode newNode = new ListNode(val);
                cur.next = newNode;
                newNode.next = next;
                break;
            } else if (next == head.next && next.val <= val && cur.val <= val) {
                ListNode newNode = new ListNode(val);
                cur.next = newNode;
                newNode.next = next;
                break;
            } else if (next == head.next && next.val >= val && cur.val >= val) {
                ListNode newNode = new ListNode(val);
                cur.next = newNode;
                newNode.next = next;
                head.next = newNode;
                break;
            }
            cur = cur.next;
            next = next.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        InsertValue iv = new InsertValue();
        ListNode node = iv.insert(new int[]{1, 3, 4, 5, 7}, new int[]{1, 2, 3, 4, 0}, 8);
        System.out.println(node.val);

        for (int i = 0; i < 6; i++) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
