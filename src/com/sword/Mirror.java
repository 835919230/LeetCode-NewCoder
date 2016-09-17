package com.sword;

import com.common.TreeNode;

/**
 * Created by 诚 on 2016/9/11.
 * 二叉树的镜像。
 */
public class Mirror {
    public void Mirror(TreeNode root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)//代表找到叶子了
            return;
        Mirror(root.left);
        Mirror(root.right);
        swap(root);
    }

    private void swap(TreeNode root) {
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }
}
