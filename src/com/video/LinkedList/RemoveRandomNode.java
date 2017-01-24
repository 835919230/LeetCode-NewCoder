package com.video.LinkedList;

import com.common.ListNode;

/**
 * Created by hexi on 17-1-23.
 * 把next的value给当前的node，再把当前node.next指向next.next
 */
public class RemoveRandomNode {
    public boolean removeNode(ListNode pNode) {
        if (pNode == null || pNode.next == null)
            return false;
        ListNode next = pNode.next;
        pNode.val = next.val;
        pNode.next = next.next;
        return true;
    }
}
