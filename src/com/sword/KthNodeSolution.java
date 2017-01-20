package com.sword;

import com.common.TreeNode;

/**
 * Created by HeXi on 2017/1/20.
 */
public class KthNodeSolution {

    private TreeNode head;
    private TreeNode realHead;

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (k <= 0)
            return null;
        traverse(pRoot);
        TreeNode node = realHead;
        int i = 1;
        while (node != null && i++ < k) {
            node = node.right;
        }
        return node;
    }

    private void traverse(TreeNode node) {
        if (node == null)
            return;
        traverse(node.left);
        if (head == null) {
            head = node;
            realHead = head;
        } else {
            head.right = node;
            node.left = head;
            head = node;
        }
        traverse(node.right);
    }
}
