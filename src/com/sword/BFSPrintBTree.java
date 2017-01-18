package com.sword;

import com.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by HeXi on 2017/1/17.
 */
public class BFSPrintBTree {
    static class Solution {
        public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
            ArrayList<Integer> list = new ArrayList<>();
            if (root == null)
                return list;
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            traverse(queue, list);
            return list;
        }

        private void traverse(LinkedList<TreeNode> queue, ArrayList<Integer> list) {
            if (queue == null || list == null || queue.isEmpty())
                return;
            TreeNode node = queue.removeFirst();
            TreeNode left = node.left;
            TreeNode right = node.right;
            if (left != null)
                queue.add(left);
            if (right != null)
                queue.add(right);
            list.add(node.val);
            traverse(queue, list);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = null;
        root.left = left;
        root.right = right;
        TreeNode node = new TreeNode(3);
        left.left = node;
        ArrayList<Integer> list = solution.PrintFromTopToBottom(root);
        for (Integer integer : list)
            System.out.println(integer);
    }
}
