package com.sword;

import com.common.TreeNode;
import com.common.TreeNodeFactory;

/**
 * Created by HeXi on 2017/1/19.
 */
public class IsBalancedBTree {
    private boolean isBalanced = true;
    public boolean IsBalanced_Solution(TreeNode root) {
        getHeight(root);
        return isBalanced;
    }

    private int getHeight(TreeNode node) {
        if (node == null)
            return 0;
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        if (Math.abs(left - right) > 1)
            isBalanced = false;
        return 1 + max(left, right);
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    public static void main(String[] args) {
        TreeNodeFactory fac = TreeNodeFactory.getInstance();
        TreeNode root = fac.createTreeNode(1);
        root.left = fac.createTreeNode(2);
        root.left.left = fac.createTreeNode(3);
        IsBalancedBTree s = new IsBalancedBTree();
        System.out.println(s.IsBalanced_Solution(root));
        System.out.println(s.getHeight(root.left));
    }
}
