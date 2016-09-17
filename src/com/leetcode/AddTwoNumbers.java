package com.leetcode;

/**
 * Created by 诚 on 2016/9/7.
 * @see @link https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1,ListNode l2) {
        ListNode x, y, cur;
        int carry = 0;
        x = l1; y = l2;
        ListNode head = new ListNode(0);
        cur = head;
        while (x != null || y != null) {
            int a = (x == null) ? 0 : x.val;
            int b = (y == null) ? 0 : y.val;

            int rel = a + b + carry;
            carry = rel / 10;
            rel %= 10;

            ListNode newNode = new ListNode(rel);
            cur.next = newNode;
            cur = cur.next;

            if (x != null)
                x = x.next;
            if (y != null)
                y = y.next;
        }
        if (carry > 0)
            cur.next = new ListNode(carry);
        return head.next;
    }

    public void show(ListNode node) {
        while (node != null) {
            System.out.print(node.val + ((node.next != null) ? "->":""));
            node = node.next;
        }
        System.out.println();
    };

    public ListNode createList(int... nums) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (int i = 0; i < nums.length; i++) {
            ListNode newNode = new ListNode(nums[i]);
            cur.next = newNode;
            cur = cur.next;
        }
        return head.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l1 = addTwoNumbers.createList(1,8);
        ListNode l2 = addTwoNumbers.createList(9);
        ListNode node = addTwoNumbers.addTwoNumbers(l1, l2);
        addTwoNumbers.show(node);
    }
}
