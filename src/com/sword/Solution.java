package com.sword;

import com.common.TreeNode;

/**
 * Created by 诚 on 2016/9/10.
 * 树的子结构
 */
public class Solution {
    StringBuilder sb1;
    StringBuilder sb2;
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        sb1 = new StringBuilder();
        sb2 = new StringBuilder();
        firstTravel(root1,sb1);
        firstTravel(root2,sb2);
        String str1 = sb1.toString();
        String str2 = sb2.toString();
        if (str2.equals(""))
            return false;
        return str1.contains(str2);
    }

    private void firstTravel(TreeNode node,StringBuilder sb){
        if (node == null)
            return;
        sb.append(node.val);
        firstTravel(node.left,sb);
        firstTravel(node.right,sb);
    };
}
