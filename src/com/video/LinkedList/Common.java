package com.video.LinkedList;

import com.common.ListNode;
import com.common.ListNodeFactory;

import java.util.ArrayList;

/**
 * Created by hexi on 17-1-24.
 */
public class Common {
    public static int[] findCommonParts(ListNode headA, ListNode headB) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != null && p2 != null) {
            if (p1.val > p2.val) {
                p2 = p2.next;
            } else if (p1.val < p2.val) {
                p1 = p1.next;
            } else {
                list.add(p1.val);
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        int[] eqs = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            eqs[i] = list.get(i);
        }
        return eqs;
    }

    public static void main(String[] args) {
        ListNodeFactory fac = ListNodeFactory.getInstance();
        ListNode headA = fac.constructLinkedList(new int[]{1, 2, 3, 4, 5, 6, 7});
        ListNode headB = fac.constructLinkedList(new int[]{2, 4, 6, 8, 10});
        int[] commonParts = findCommonParts(headA, headB);
        for (int i = 0; i < commonParts.length; i++) {
            System.out.println(commonParts[i]);
        }
    }
}
