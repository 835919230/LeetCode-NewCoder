package com.leetcode.tree;

import com.common.TreeNode;

/**
 * 二叉搜索树的最近公共祖先
 */
public class No235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;

        while (true) {
            if (ancestor == null) {
                break;
            }
            if (p.val < ancestor.val && q.val < ancestor.val) {
                ancestor = ancestor.left;
            } else if (p.val > ancestor.val && q.val > ancestor.val) {
                ancestor = ancestor.right;
            } else {
                break;
            }
        }
        return ancestor;
    }
}
