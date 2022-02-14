package com.leetcode.tree;

import com.common.TreeNode;

/**
 * 删除二叉搜索树的节点，递归实现，思路分为三个点
 * 1.如果删除的是叶子节点，return null即可
 * 2.如果删除的不是叶子节点，且该节点左孩子或者右孩子为空，用不为空的那一个孩子替换（return）即可
 * 3.如果删除的不是叶子节点，且该节点左孩子和右孩子都不为空，要么用左子树的最大值来替换，要么用右子树的最小值来替换
 */
public class No450 {
    class Solution {
        /*
        One step right and then always left
        */
        public int successor(TreeNode root) {
            root = root.right;
            while (root.left != null) root = root.left;
            return root.val;
        }

        /*
        One step left and then always right
        */
        public int predecessor(TreeNode root) {
            root = root.left;
            while (root.right != null) root = root.right;
            return root.val;
        }

        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) return null;

            // delete from the right subtree
            if (key > root.val) root.right = deleteNode(root.right, key);
                // delete from the left subtree
            else if (key < root.val) root.left = deleteNode(root.left, key);
                // delete the current node
            else {
                // the node is a leaf
                if (root.left == null && root.right == null) root = null;
                    // the node is not a leaf and has a right child
                else if (root.right != null) {
                    root.val = successor(root);
                    root.right = deleteNode(root.right, root.val);
                }
                // the node is not a leaf, has no right child, and has a left child
                else {
                    root.val = predecessor(root);
                    root.left = deleteNode(root.left, root.val);
                }
            }
            return root;
        }
    }
}
