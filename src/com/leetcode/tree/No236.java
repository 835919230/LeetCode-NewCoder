package com.leetcode.tree;

import com.common.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class No236 {
    Map<Integer, TreeNode> parentMap = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p != null) {
            visited.add(p.val);
            p = parentMap.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parentMap.get(q.val);
        }
        return null;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            parentMap.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parentMap.put(root.right.val, root);
            dfs(root.right);
        }
    }
}
