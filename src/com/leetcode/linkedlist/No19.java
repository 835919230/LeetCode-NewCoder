package com.leetcode.linkedlist;

import com.common.ListNode;

public class No19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;

        int len = 0;
        while (fast != null) {
            len++;
            fast = fast.next;
        }
        ListNode pre = null;
        for (int i = 0; i < len - n; i++) {
            pre = slow;
            slow = slow.next;
        }
        if (pre != null) {
            pre.next = slow.next;
            return head;
        } else {
            return slow.next;
        }

    }
}
