package com.leetcode.tree;

import com.common.TreeNode;
import java.util.*;

/**
 * 判断是否是镜像二叉树，这里要注意有个递推的关系 l.left and r.right or  l.right and r.left
 */
public class No1290 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return recur(root.left, root.right);
    }
    private boolean recur(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;
        if (l == null || r == null || l.val != r.val) return false;
        return recur(l.left, r.right) && recur(l.right, r.left);
    }
}
