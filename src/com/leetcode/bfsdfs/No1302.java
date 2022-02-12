package com.leetcode.bfsdfs;

import com.common.TreeNode;
import java.util.*;

public class No1302 {
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int res = 0;
        while (!queue.isEmpty()) {
            int levelCount = queue.size();
            res = 0;
            for (int i = 0; i < levelCount; i++) {
                TreeNode node = queue.poll();
                res += node.val;

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }
}
