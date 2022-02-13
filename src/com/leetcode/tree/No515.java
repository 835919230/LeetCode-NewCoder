package com.leetcode.tree;

import com.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 在每个树行中找最大值
 */
public class No515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            int maxValue = Integer.MIN_VALUE;
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                maxValue = Integer.max(maxValue, node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(maxValue);
        }
        return res;
    }
}
