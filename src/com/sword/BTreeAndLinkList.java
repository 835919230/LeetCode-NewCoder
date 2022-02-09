package com.sword;

import com.common.TreeNode;

/**
 * Created by HeXi on 2017/1/18.
 * 输入一棵二叉搜索树，
 * 将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，
 * 只能调整树中结点指针的指向。
 *
 * 思路是利用中序遍历，找出最后修改的head（也就是形成链表过程中的最大值节点）
 */
public class BTreeAndLinkList {
    static class Solution {
        private TreeNode head = null;
        public TreeNode Convert(TreeNode pRootOfTree) {
            if (pRootOfTree == null)
                return null;
            TreeNode realHead = pRootOfTree;
            while(realHead.left != null) {
                realHead = realHead.left;
            }
            traverse(pRootOfTree);
            return realHead;
        }
        private void traverse(TreeNode node) {
            if (node == null)
                return;
            traverse(node.left);
            if (head == null) {
                head = node;
            } else {
                head.right = node;
                node.left = head;
                head = node;
            }
            traverse(node.right);
        }
    }
}
