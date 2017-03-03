package com.video.LinkedList;

import com.common.ListNode;
import com.common.ListNodeFactory;

/**
 * Created by hexi on 17-1-26.
 */
public class CheckIntersect {
    /**
     * 判断两个无环链表是否相交
     *
     * @param headA
     * @param headB
     * @return
     */
    public static boolean chkIntersect(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;

        int lenA = lengthOf(p1);
        int lenB = lengthOf(p2);
        int div = 0;
        if (lenA > lenB) {
            div = lenA - lenB;
            p1 = walkLength(p1, div);
        } else {
            div = lenB - lenA;
            p2 = walkLength(p2, div);
        }
        while (p1 != null && p2 != null) {
            if (p1 == p2)
                return true;
            p1 = p1.next;
            p2 = p2.next;
        }
        return false;
    }

    private static ListNode walkLength(ListNode head, int len) {
        int i = 0;
        while (head != null && i++ < len) {
            head = head.next;
        }
        return head;
    }

    private static int lengthOf(ListNode head) {
        ListNode p = head;
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }
        return len;
    }

    public static boolean bestSolution(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return false;
        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1.next != null) {
            p1 = p1.next;
        }
        while (p2.next != null)
            p2 = p2.next;
        return p1 == p2;
    }

    public static ListNode chkInter(ListNode head1, ListNode head2, int adjust0, int adjust1) {
        if (head1 == null || head2 == null)
            return null;
        ListNode p1 = head1;
        ListNode p2 = head2;
        ListNode enterLoopNode1 = findEnterLoopNode(p1);
        ListNode enterLoopNode2 = findEnterLoopNode(p2);
        if (enterLoopNode1 == enterLoopNode2) {
            int len1 = countLength(p1, enterLoopNode1);
            int len2 = countLength(p2, enterLoopNode2);
            if (len1 > len2) {
                int div = len1 - len2;
                p1 = walkLength(p1, div);
            } else {
                int div = len2 - len1;
                p2 = walkLength(p2, len2);
            }
            while (p1 != p2) {
                p1 = p1.next;
                p2 = p2.next;
            }
            return p1;
        } else {
            if (enterLoopNode1 == null)
                return null;
            ListNode n = enterLoopNode1.next;
            while (n != enterLoopNode2) {
                if (n == enterLoopNode1 || n == null)
                    break;
                if (n == enterLoopNode2)
                    return n;
                n = n.next;
            }
            return null;
        }
    }

    private static ListNode findEnterLoopNode(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        do {
            if (p2 == null || p2.next == null)
                break;
            p1 = p1.next;
            p2 = p2.next.next;
        } while (p1 != p2);

        if (p1 != p2)
            return null;
        p2 = head;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    private static int countLength(ListNode head, ListNode end) {
        int i = 0;
        ListNode p = head;
        while (p != null && p != end) {
            i++;
            p = p.next;
        }
        return i;
    }

    private static ListNode findIntersectNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;

        int lenA = lengthOf(p1);
        int lenB = lengthOf(p2);
        int div = 0;
        if (lenA > lenB) {
            div = lenA - lenB;
            p1 = walkLength(p1, div);
        } else {
            div = lenB - lenA;
            p2 = walkLength(p2, div);
        }
        while (p1 != null && p2 != null) {
            if (p1 == p2)
                return p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNodeFactory fac = ListNodeFactory.getInstance();
        ListNode headA = fac.constructLinkedList(new int[]{1, 2, 3, 4, 5});
        ListNode headB = fac.constructLinkedList(new int[]{1, 2, 3, 4, 5});
        System.out.println(bestSolution(headA, headB));

        ListNode headC = fac.create(5);
        headC.next = fac.create(6);
        headC.next.next = headA.next;

        System.out.println(bestSolution(headA, headC));
    }
}
