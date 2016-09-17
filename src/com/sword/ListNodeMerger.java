package com.sword;

import com.common.ListNode;

/**
 * Created by 诚 on 2016/9/10.
 */
public class ListNodeMerger {
    public ListNode Merge(ListNode list1, ListNode list2) {
        //新建一个头节点，用来存合并的链表。
        ListNode head=new ListNode(-1);
        head.next=null;
        ListNode root=head;
        while(list1!=null&&list2!=null){
            if(list1.val<list2.val){
                head.next=list1;
                head=list1;
                list1=list1.next;
            }else{
                head.next=list2;
                head=list2;
                list2=list2.next;
            }
        }
        //把未结束的链表连接到合并后的链表尾部
        if(list1!=null){
            head.next=list1;
        }
        if(list2!=null){
            head.next=list2;
        }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n3;
        n3.next = n5;
        n2.next = n4;
        n4.next = n6;
        ListNodeMerger merger = new ListNodeMerger();
        ListNode node = merger.Merge(n1, n2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
