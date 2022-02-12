package com.leetcode.bfsdfs;

import com.common.TreeNode;
import java.util.*;

public class No1609 {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean even = true;

        while (!queue.isEmpty()) {
            int levelCount = queue.size();

            int prevSize = even ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            while (levelCount > 0) {
                TreeNode node = queue.poll();
                levelCount--;

                boolean correct = even ? (node.val > prevSize && (node.val % 2 == 1)) :
                        (node.val < prevSize && (node.val % 2 == 0));
                prevSize = node.val;

                if (!correct) {
                    return false;
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            even = !even;
        }
        return true;
    }
}
