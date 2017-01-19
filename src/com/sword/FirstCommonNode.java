package com.sword;

import com.common.ListNode;
import com.common.ListNodeFactory;

/**
 * Created by HeXi on 2017/1/19.
 */
public class FirstCommonNode {
    static class Solution {
        public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
            ListNode p1 = pHead1;
            ListNode p2 = pHead2;
            int len1 = getLength(p1);
            int len2 = getLength(p2);

            if (len1 > len2) {
                int div = len1 - len2;
                p1 = passLength(p1, div);
            } else {
                int div = len2 - len1;
                p2 = passLength(p2, div);
            }

            while (p1 != null && p2 != null && p1 != p2) {
                p1 = p1.next;
                p2 = p2.next;
            }

            return p1;
        }

        public static ListNode passLength(ListNode node, int length) {
            ListNode n = node;
            int i = 0;
            while (i++ < length) {
                n = n.next;
            }
            return n;
        }

        public static int getLength(ListNode node) {
            int length = 0;
            while (node != null) {
                length++;
                node = node.next;
            }
            return length;
        }
    }

    public static void main(String[] args) {
        ListNodeFactory fac = ListNodeFactory.getInstance();
        ListNode h1 = fac.create(-1);
        h1.next = fac.create(4);
        h1.next.next = fac.create(2);
        h1.next.next.next = fac.create(3);

        ListNode h2 = fac.create();
        h2.next = fac.create(1);
        h2.next.next = h1.next;

        Solution solution = new Solution();
        ListNode listNode = solution.FindFirstCommonNode(h1, h2);
        System.out.println(listNode.val);
    }
}
