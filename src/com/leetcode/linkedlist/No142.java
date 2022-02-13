package com.leetcode.linkedlist;

import com.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 找出环形链表的入环部分
 */
public class No142 {
    public ListNode detectCycle(ListNode head) {
//        return recordTraverse(head);
        return slowFastTraverse(head);
    }

    private ListNode recordTraverse(ListNode head) {
        ListNode ptr = head;
        Set<ListNode> set = new HashSet<>();
        while (ptr != null) {
            if (set.contains(ptr)) {
                return ptr;
            }
            set.add(ptr);
            ptr = ptr.next;
        }
        return null;
    }

    private ListNode slowFastTraverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            if (fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != null) {
                    if (ptr == slow) {
                        return ptr;
                    }
                    ptr = ptr.next;
                    slow = slow.next;
                }
            }
        }
        return null;
    }

}
