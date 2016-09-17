package com.sword;

import com.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 诚 on 2016/9/10.
 * 倒序打印链表
 */
public class PrintNodeInverse {

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        curse(list, listNode);
        return list;
    }

    private static void curse(List list, ListNode node) {
        if (node == null)
            return;//表示找到了尾节点的next
        curse(list, node.next);
        list.add(node.val);
    }

    static ListNode createTestCase(){
        ListNode head = null;
        ListNode last = null;
        for (int i = 0; i < 10; i++) {
            ListNode node = new ListNode(i);
            if (i != 0)
                last.next = node;
            last = node;
            if (i == 0)
                head = node;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = createTestCase();
        System.out.println(head.val == 0 && head != null);
        ArrayList<Integer> integers = printListFromTailToHead(head);
        for (int i = 0; i < integers.size(); i++) {
            System.out.print(integers.get(i));
        }
        System.out.println();
    }
}
