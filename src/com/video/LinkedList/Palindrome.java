package com.video.LinkedList;

import com.common.ListNode;
import com.common.ListNodeFactory;

import java.util.Stack;

/**
 * Created by hexi on 17-1-24.
 */
public class Palindrome {
    public static boolean isPalindrome(ListNode pHead) {
        Stack<Integer> stack = new Stack<>();
        ListNode node = pHead;
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        node = pHead;
        while (node != null) {
            int pop = stack.pop();
            if (node.val == pop)
                node = node.next;
            else return false;
        }
        return true;
    }

    //最优解
    public static boolean _isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode n1 = head;
        ListNode n2 = head;
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }

        n2 = n1.next;
        n1.next = null;//n1 is the middle node and n1.next must point to null
        ListNode n3 = null;
        //reverse the nodes after middle node
        while (n2 != null) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        n2 = n1;
        n1 = head;
        n3 = n2;//restore the tail
        boolean res = true;
        //compare two linkedlist
        while (n2 != null && n1 != null) {
            if (n2.val != n1.val)
                res = false;
            n2 = n2.next;
            n1 = n1.next;
        }
        //fix the linkedlist
        n2 = n3.next;
        n3.next = null;
        while (n2 != null) {
            n1 = n2.next;
            n2.next = n3;
            n3 = n2;
            n2 = n1;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNodeFactory fac = ListNodeFactory.getInstance();
        int[] testCaseA = {1, 2, 3, 2, 1};
        int[] testCaseB = {1, 2, 3, 2, 3};
        int[] testCaseC = {5, 2, 2, 3, 7, 0, 7, 2, 1, 0, 6, 1, 0, 3, 3, 3, 4, 3, 4, 5, 5, 4, 9, 0, 9, 4, 0, 6, 3, 2, 2, 1, 6, 7, 1, 8, 2, 8, 0, 6, 0, 0, 4, 1, 8, 2, 2, 8, 1, 4, 0, 0, 6, 0, 8, 2, 8, 1, 7, 6, 1, 2, 2, 3, 6, 0, 4, 9, 0, 9, 4, 5, 5, 4, 3, 4, 3, 3, 3, 0, 1, 6, 0, 1, 2, 7, 0, 7, 3, 2, 2, 5};
        System.out.println(isPalindrome(fac.constructLinkedList(testCaseA)));
        System.out.println(isPalindrome(fac.constructLinkedList(testCaseB)));

        System.out.println("------------------------------------------");
        System.out.println(_isPalindrome(fac.constructLinkedList(testCaseA)));
        System.out.println(_isPalindrome(fac.constructLinkedList(testCaseB)));
        System.out.println(_isPalindrome(fac.constructLinkedList(testCaseC)));
    }
}
