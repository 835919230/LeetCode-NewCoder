package com.leetcode.tree;

import com.common.TreeNode;
import java.util.*;

/**
 * 二叉树的镜像
 */
public class No1612 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                TreeNode tmp = node.left;
                node.left = node.right;
                node.right = tmp;

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }
}
