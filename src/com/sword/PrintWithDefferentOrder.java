package com.sword;

import com.common.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by HeXi on 2017/1/20.
 */
public class PrintWithDefferentOrder {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        if (pRoot == null)
            return lists;
        boolean leftToRight = true;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(null);//层分隔符
        queue.add(pRoot);
        while (queue.size() != 1) {
            TreeNode first = queue.removeFirst();
            if (first == null) {
                Iterator<TreeNode> itr;
                if (leftToRight) {
                    itr = queue.iterator();
                } else {
                    itr = queue.descendingIterator();
                }
                ArrayList<Integer> list = new ArrayList<>();
                while (itr.hasNext()) {
                    TreeNode node = itr.next();
                    list.add(node.val);
                }
                lists.add(list);
                queue.add(null);
                leftToRight = !leftToRight;
            } else {
                if (first.left != null)
                    queue.add(first.left);
                if (first.right != null)
                    queue.add(first.right);
            }

        }

        return lists;
    }
}
