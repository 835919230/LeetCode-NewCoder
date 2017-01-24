package com.video.LinkedList;

import com.common.ListNode;
import com.common.ListNodeFactory;

/**
 * Created by hexi on 17-1-24.
 */
public class ClearValue {
    public static ListNode clear(ListNode head, int val) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            if (cur.val == val) {
                if (pre == null) {
                    cur.next = null;
                    head = next;
                } else {
                    pre.next = cur.next;
                }
            } else {
                //防止连续的情况
                pre = cur;
            }
            cur = next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] testCase = new int[]
                {22, 26, 21, 17, 20, 15, 10, 18,
                        3, 14, 11, 9, 23, 4, 20, 14, 7, 24,
                        17, 27, 23, 6, 6, 17, 12, 11, 22,
                        9, 6, 3, 5, 17, 28, 8, 6, 13, 19, 14,
                        9, 13, 25, 3, 28, 23, 19, 17, 19, 16,
                        28, 25, 9, 7, 23, 1, 24, 12, 26, 15, 21,
                        24, 23, 9, 9, 23, 13, 8, 13, 12, 4, 2, 20,
                        10, 21, 8, 8, 17, 16, 4, 21, 3, 14, 15, 12,
                        24, 20, 23, 22, 15, 28, 19, 3, 3, 21, 17, 21,
                        27, 10, 1, 14, 12, 28, 15, 9, 11, 3, 17, 13,
                        9, 4, 27, 15, 2, 13, 23, 6, 15, 23, 2, 3, 21,
                        24, 18, 14, 3, 2, 18, 17, 28, 28, 5, 26, 26,
                        22, 12, 9, 16, 10, 5, 13, 12, 21, 3, 12, 17,
                        6, 23, 18, 8, 16, 26, 9, 25, 23, 10, 19, 6,
                        26, 15, 3, 6, 8, 2, 24, 12, 15, 20, 20, 25,
                        23, 2, 12, 15, 22, 16, 10, 27, 9, 1, 25, 17,
                        14, 17, 19, 5, 23, 24, 27, 5, 21, 23, 4, 5,
                        12, 19, 10, 27, 11, 9, 15, 18, 22, 26, 28, 21,
                        3, 11, 13, 22, 5, 19, 25, 16, 12, 17, 16, 5, 4,
                        11, 7, 27, 19, 16, 1, 12, 28};
        int cVal = 9;
        ListNode head = clear(ListNodeFactory.getInstance().constructLinkedList(testCase), cVal);
        while (head != null) {
            if (head.val == cVal)
                System.out.println("contains!");
            head = head.next;
        }
    }
}
