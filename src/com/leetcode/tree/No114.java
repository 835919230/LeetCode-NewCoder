package com.leetcode.tree;

import com.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class No114 {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        firstOrder(root, list);

        for (int i = 1; i < list.size(); i++) {
            TreeNode node = list.get(i);
            root.right = node;
            root.left = null;
            root = root.right;
        }
    }

    private void firstOrder(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root);
        firstOrder(root.left, list);
        firstOrder(root.right, list);
    }
}
