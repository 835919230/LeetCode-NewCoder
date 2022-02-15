package com.leetcode.tree;

import com.common.TreeNode;

/**
 * 判断树B是不是树A的子结构
 * 思路：根节点开始判断，或者根节点的左子结构，或者根节点的右子结构
 */
public class No1424 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return isSub(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean isSub(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return isSub(A.left, B.left) && isSub(A.right, B.right);
    }
}
