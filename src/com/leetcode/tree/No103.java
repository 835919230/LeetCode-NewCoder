package com.leetcode.tree;

import com.common.TreeNode;

import java.util.*;

public class No103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            LinkedList<Integer> content = new LinkedList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (leftToRight) {
                    content.addLast(node.val);
                } else {
                    content.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            leftToRight = !leftToRight;
            list.add(content);
        }
        return list;
    }
}
