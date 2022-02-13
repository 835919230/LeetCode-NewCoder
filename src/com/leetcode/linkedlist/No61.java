package com.leetcode.linkedlist;

import com.common.ListNode;

/**
 * 链表节点支持循环转移
 */
public class No61 {
    public ListNode rotateRight(ListNode head, int k) {
        int len = 0;
        ListNode ptr = head, tail = null;
        while (ptr != null) {
            len++;
            if (ptr.next == null) {
                tail = ptr;
            }
            ptr = ptr.next;
        }
        if (len == 0) {
            return null;
        }
        tail.next = head;
        int moveStep = len - (k % len);
        ptr = head;
        ListNode pre = null;
        for (int i = 0; i < moveStep; i++) {
            pre = ptr;
            ptr = ptr.next;
        }
        if (pre == null) {
            return ptr;
        }
        pre.next = null;
        return ptr;
    }
}
