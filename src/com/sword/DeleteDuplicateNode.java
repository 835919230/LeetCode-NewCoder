package com.sword;

import com.common.ListNode;

/**
 * Created by HeXi on 2017/1/20.
 */
public class DeleteDuplicateNode {
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode first = new ListNode(-1);
        first.next = pHead;

        ListNode p = pHead;
        ListNode last = first;

        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                int val = p.val;
                while (p != null && p.val == val)
                    p = p.next;
                last.next = p;
            } else {
                last = p;
                p = p.next;
            }
        }

        return first.next;
    }
}
