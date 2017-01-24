package com.video.LinkedList;

import com.common.RandomListNode;

/**
 * Created by hexi on 17-1-24.
 */
public class RandomLinkedList {
    public static RandomListNode Clone(RandomListNode head) {
        if (head == null)
            return null;
        RandomListNode h = head;
        while (h != null) {
            RandomListNode node = new RandomListNode(h.label);
            RandomListNode next = h.next;
            h.next = node;
            node.next = next;
            h = next;
        }
        h = head;
        RandomListNode n = h.next;
        while (h != null) {
            RandomListNode next = h.next;
            if (h.random != null)
                next.random = h.random.next;
            h = next.next;
        }

        h = head;
        RandomListNode res = head.next;
        while (h != null) {
            RandomListNode next = h.next;
            h.next = next.next;
            h = next.next;
            if (h != null)
                next.next = h.next;
        }
        return res;
    }

    public static void main(String[] args) {
        RandomListNode one = new RandomListNode(1);
        RandomListNode two = new RandomListNode(2);
        RandomListNode three = new RandomListNode(3);
        one.next = two;
        one.random = three;
        two.next = three;
        two.random = two;
        three.random = two;

        RandomListNode node = Clone(one);
        while (node != null) {
            System.out.println(node.label);
            System.out.println(node.random);
            System.out.println();
            node = node.next;
        }
    }
}
