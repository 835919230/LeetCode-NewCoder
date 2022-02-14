package com.leetcode.tree;

import com.common.TreeNode;

/**
 * 验证二叉搜索树
 */
public class No98 {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValid(TreeNode root, int minVal, int maxVal) {
        if (root == null) {
            return true;
        }
        if (root.val < minVal || root.val > maxVal) {
            return false;
        }
        return isValid(root.left, minVal, root.val) && isValid(root.right, root.val, maxVal);
    }
}
