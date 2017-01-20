package com.sword;

import com.common.ListNode;
import com.common.TreeLinkNode;

import java.util.LinkedList;

/**
 * Created by HeXi on 2017/1/20.
 */
public class GetNextMiddleOrderNode {
    private LinkedList<TreeLinkNode> linkNodes = new LinkedList<>();

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        TreeLinkNode node = pNode;
        while (node != null && node.next != null) {
            node = node.next;
        }
        midOrder(node, pNode);

        for (int i = 0; i < linkNodes.size(); i++) {
            TreeLinkNode treeLinkNode = linkNodes.get(i);
            if (treeLinkNode == pNode)
                return i + 1 >= linkNodes.size() ? null : linkNodes.get(i + 1);
        }
        return null;
    }

    public TreeLinkNode getNext(TreeLinkNode node) {
        if (node == null) return null;
        if (node.right != null) {    //如果有右子树，则找右子树的最左节点
            node = node.right;
            while (node.left != null) node = node.left;
            return node;
        }
        while (node.next != null) { //没右子树，则找第一个当前节点是父节点左孩子的节点
            if (node.next.left == node) return node.next;
            node = node.next;
        }
        return null;   //退到了根节点仍没找到，则返回null
    }

    private void midOrder(TreeLinkNode root, TreeLinkNode pNode) {
        if (root == null)
            return;
        midOrder(root.left, pNode);
        linkNodes.add(root);
        midOrder(root.right, pNode);
    }
}
