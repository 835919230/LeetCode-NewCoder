package com.video.LinkedList;

import com.common.ListNode;
import com.common.ListNodeFactory;

/**
 * Created by hexi on 17-1-26.
 */
public class ChkLoop {
    public static int chkLoop(ListNode head, int adjust) {
        if (head == null || head.next == null) {
            return -1;
        }

        ListNode p1 = head;
        ListNode p2 = head;
        boolean first = true;
        while (p2 != null && p2.next != null) {
            if (p1 == p2 && !first)
                break;
            if (first)
                first = false;
            p1 = p1.next;
            p2 = p2.next.next;
        }

        if (p2 == null || p2.next == null)
            return -1;

        p2 = head;

        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1.val;
    }

    public static void main(String[] args) {
        ListNodeFactory fac = ListNodeFactory.getInstance();
        ListNode head = fac.constructLinkedList(new int[]{1, 2, 3, 4, 5});

        head.next.next.next.next.next = head.next.next;

        System.out.println(chkLoop(head, 2));
    }
}
