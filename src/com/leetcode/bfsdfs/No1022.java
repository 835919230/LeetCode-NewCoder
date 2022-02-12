package com.leetcode.bfsdfs;

import com.common.TreeNode;

public class No1022 {

    private static class ResHolder {
        int val = 0;
    }

    private void dfs(TreeNode root, int sum, ResHolder resHolder) {
        if (root == null) {
            return;
        }
        sum = sum * 2 + root.val;

        if (root.left != null) {
            dfs(root.left, sum, resHolder);
        }
        if (root.right != null) {
            dfs(root.right, sum, resHolder);
        }

        if (root.left == null && root.right == null) {
            resHolder.val = resHolder.val + sum;
        }
    }

    public int sumRootToLeaf(TreeNode root) {
        ResHolder resHolder = new ResHolder();
        dfs(root, 0, resHolder);

        return resHolder.val;
    }
}
