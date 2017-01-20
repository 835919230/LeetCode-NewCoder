package com.sword;

import com.common.TreeNode;
import com.common.TreeNodeFactory;

/**
 * Created by HeXi on 2017/1/20.
 */
public class SymmetricalBTree {
    boolean rel = true;
    boolean isSymmetrical(TreeNode pRoot) {
        traverse(pRoot);
        return rel;
    }

    void traverse(TreeNode node) {
        if (node == null)
            return;
        if (node.left == null && node.right == null)
            return;
        else if (node.left == null)
            rel = false;
        else if (node.right == null)
            rel = false;
        if (node.left != null && node.right != null && node.left.val != node.right.val) {
            rel = false;
        }
        traverse(node.left);
        traverse(node.right);
    }

    public static void main(String[] args) {
        TreeNodeFactory fac = TreeNodeFactory.getInstance();
        TreeNode root = fac.createTreeNode(2);
        root.left = fac.createTreeNode(1);
        root.right = fac.createTreeNode(1);
        root.right = null;
        System.out.println(new SymmetricalBTree().isSymmetrical(root));
    }
}
