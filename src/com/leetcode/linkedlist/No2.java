package com.leetcode.linkedlist;

import com.common.ListNode;

/**
 * 两链表表示数字的和，输出另一个链表
 */
public class No2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        int adder = 0;
        while (l1 != null || l2 != null) {
            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;

            int sum = l1Val + l2Val + adder;
            adder = sum / 10;
            sum = sum % 10;

            ListNode node = new ListNode(sum);
            tail.next = node;
            tail = node;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (adder != 0) {
            tail.next = new ListNode(adder);
        }
        return head.next;
    }
}
