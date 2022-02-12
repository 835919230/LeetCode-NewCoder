package com.leetcode.linkedlist;

import com.common.ListNode;

/**
 * 判断链表是否有环
 */
public class No141 {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
