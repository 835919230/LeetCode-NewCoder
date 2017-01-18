package com.sword;

import com.common.TreeNode;
import com.common.TreeNodeFactory;

/**
 * Created by HeXi on 2017/1/18.
 */
public class TreeDepth {
    static class Solution {
        public int TreeDepth(TreeNode root) {
            if (root == null)
                return 0;
            return 1 + max(TreeDepth(root.left), TreeDepth(root.right));
        }

        public static int max(int a, int b) {
            return a > b ? a : b;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNodeFactory fac = TreeNodeFactory.getInstance();
        TreeNode root = fac.createTreeNode(1);
        root.left = fac.createTreeNode(2);
        root.right = fac.createTreeNode(3);
        int depth = solution.TreeDepth(root);
        System.out.println(depth);

        TreeNode singleNode = fac.createTreeNode(0);
        System.out.println(solution.TreeDepth(singleNode));

        TreeNode onlyRoot = fac.createTreeNode(1);
        onlyRoot.left = fac.createTreeNode(1);

        System.out.println(solution.TreeDepth(onlyRoot));
    }
}
