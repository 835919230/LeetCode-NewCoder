package com.leetcode.tree;

import com.common.TreeNode;

/**
 * 求二叉树的最大深度，每递归一层都需要手动+1，遇到null就返回0
 */
public class No104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
