package com.leetcode.bfsdfs;

import com.common.TreeNode;
import java.util.*;

public class No993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelCount = queue.size();

            Set<Integer> levelValueSet = new HashSet<>();
            for (int i = 0; i < levelCount; i++) {
                TreeNode node = queue.poll();
                levelValueSet.add(node.val);

                if (node.left != null && node.right != null) {
                    // 不能是兄弟节点
                    if ((node.left.val == x && node.right.val == y) || (node.left.val == y && node.right.val == x)) {
                        return false;
                    }
                }

                if (node.left != null) {
                    queue.offer(node);
                }
                if (node.right != null) {
                    queue.offer(node);
                }
            }
            if (levelValueSet.contains(x) && levelValueSet.contains(y)) {
                return true;
            }
        }
        return false;
    }
}
