package com.leetcode.tree;

import com.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最小深度，从根节点找到层数最浅的叶子节点
 */
public class No111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            level++;
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                if (node.left == null && node.right == null) {
                    return level;
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return level;
    }
}
