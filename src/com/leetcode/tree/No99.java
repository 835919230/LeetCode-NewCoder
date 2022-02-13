package com.leetcode.tree;

import com.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉搜索树恰好有两个节点的是错误的，不满足二叉搜索树的要求的，找出来并且交换
 * 利用二叉搜索树的中序遍历是有序的特点，而且这题要注意prev不是parent，切记，可以多画几层，然后手动画着遍历一下，就明白了。
 */
public class No99 {
    TreeNode first = null;
    TreeNode second = null;
    public void recoverTree(TreeNode root) {
        inOrder(null, root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    private void inOrder(TreeNode prev, TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root, root.left);
        if (first == null && prev != null && prev.val > root.val) {
            first = prev;
        }

        if (first != null && prev != null && prev.val > root.val) {
            second = root;
        }

        inOrder(root, root.right);
    }

    /**
     * 二叉树的中序遍历
     */
    private void inOrderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                // 做中序遍历的逻辑操作
                System.out.println(root.val);
                root = root.right;
            }
        }
    }

    private void inOrderTraversalRecoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        TreeNode first = null;
        TreeNode second = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                if (first == null && pre != null && pre.val > root.val) {
                    first = pre;
                }
                // 这里是root需要交换
                if (first != null && pre.val > root.val) {
                    second = root;
                }
                pre = root;
                root = root.right;
            }
        }
        if (first != null && second != null) {
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }
    }

    /**
     * morris二叉树中序遍历模板
     *
     * @param root
     */
    private List<Integer> morrisInOrderTraversalTemplate(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                res.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                // 假如pre的右儿子是空，就把它指向cur,cur继续向左遍历
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                }
                // 假如pre的右儿子不为空，那么这个时候就已经指向cur了，需要还原这棵树 pre.right = null，继续向右遍历
                else {
                    pre.right = null;
                    res.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return res;
    }

    /**
     * morris前序遍历二叉树模板
     *
     * @param root
     */
    private List<Integer> morrisFirstOrderTraversalTemplate(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                res.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    res.add(cur.val);
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    pre.right = null;
                    cur = cur.right;
                }
            }
        }
        return res;
    }
}
