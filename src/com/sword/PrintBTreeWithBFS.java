package com.sword;

import com.common.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by HeXi on 2017/1/20.
 */
public class PrintBTreeWithBFS {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        if (pRoot == null) {
            return lists;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(null);
        queue.add(pRoot);
        while (queue.size() != 1) {
            TreeNode head = queue.removeFirst();
            if (head == null) {
                Iterator<TreeNode> itr = queue.iterator();
                ArrayList<Integer> list = new ArrayList<>();
                while (itr.hasNext()) {
                    TreeNode node = itr.next();
                    list.add(node.val);
                }
                lists.add(list);
                queue.add(null);
            } else {
                if (head.left != null)
                    queue.add(head.left);
                if (head.right != null)
                    queue.add(head.right);
            }
        }
        return lists;
    }
}
