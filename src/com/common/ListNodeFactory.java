package com.common;

/**
 * Created by HeXi on 2017/1/19.
 */
public class ListNodeFactory {
    private ListNodeFactory() {
    }

    private static ListNodeFactory instance;

    public static ListNodeFactory getInstance() {
        if (instance == null) {
            synchronized (ListNodeFactory.class) {
                if (instance == null) {
                    instance = new ListNodeFactory();
                }
            }
        }

        return instance;
    }

    public ListNode constructLinkedList(int[] arr) {
        ListNode head = new ListNode(-1);
        if (arr == null || arr.length <= 0)
            return head.next;
        ListNode n = head;
        for (int i = 0; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            n.next = node;
            n = node;
        }
        return head.next;
    }

    public static ListNode create(int val) {
        return new ListNode(val);
    }

    public static ListNode create() {
        return create(-1);
    }
}
