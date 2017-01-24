package com.video.LinkedList;

import com.common.ListNode;
import com.common.ListNodeFactory;

/**
 * Created by hexi on 17-1-24.
 */
public class KInverse {
    public ListNode inverse(ListNode head, int K) {
        if (K < 2)
            return head;
        int count = 1;
        ListNode cur = head;
        ListNode left = null;
        ListNode right = null;

        ListNode last = null;

        while (cur != null) {
            ListNode next = cur.next;
            if (count == K) {
                left = last == null ? head : last.next;
                right = cur;
                head = last == null ? right : head;
                count = 0;
                ListNode newHead = reverse(left, left, cur, next);
                if (last != null)
                    last.next = newHead;
                last = left;
            }
            cur = next;
            count++;
        }
        return head;
    }

    private ListNode reverse(ListNode left, ListNode start, ListNode end, ListNode right) {
        ListNode pre = start;
        ListNode cur = start.next;
        while (cur != right) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        left.next = right;
        return end;
    }

    public static void main(String[] args) {
        ListNodeFactory fac = ListNodeFactory.getInstance();
        ListNode head = fac.constructLinkedList(new int[]{3, 2, 1, 6, 5, 4, 7, 8});
        KInverse ki = new KInverse();
        ListNode newHead = ki.inverse(head, 3);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}
