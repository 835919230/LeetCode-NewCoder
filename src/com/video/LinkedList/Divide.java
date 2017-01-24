package com.video.LinkedList;

import com.common.ListNode;
import com.common.ListNodeFactory;

/**
 * Created by hexi on 17-1-24.
 */
public class Divide {
    public static ListNode listDivide(ListNode head, int val) {
        if (head == null)
            return null;
        ListNode h1 = new ListNode(-1);
        ListNode h3 = new ListNode(-1);

        ListNode hh1 = h1;
        ListNode hh3 = h3;

        while (head != null) {
            ListNode node = new ListNode(head.val);
            if (head.val <= val) {
                h1.next = node;
                h1 = node;
            } else {
                h3.next = node;
                h3 = node;
            }
            head = head.next;
        }

        if (h1 != hh1)
            h1.next = hh3.next;

        return hh1.next != null ? hh1.next : hh3.next;
    }

    public static void main(String[] args) {
        ListNodeFactory fac = ListNodeFactory.getInstance();
        ListNode head = fac.create(1620);
        ListNode two = fac.create(1134);
        ListNode three = fac.create(861);
        ListNode four = fac.create(563);
        head.next = two;
        two.next = three;
        three.next = four;
        int val = 1134;

        ListNode newHead = listDivide(head, val);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}
