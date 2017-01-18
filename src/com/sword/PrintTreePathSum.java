package com.sword;

import com.common.TreeNode;
import com.common.TreeNodeFactory;

import java.util.ArrayList;

/**
 * Created by HeXi on 2017/1/18.
 * 输入一颗二叉树和一个整数，
 * 打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * {@link https://www.nowcoder.com/practice/b736e784e3e34731af99065031301bca?tpId=13&tqId=11177&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking}
 */
public class PrintTreePathSum {
    static class Solution {
        private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
        private ArrayList<Integer> list = new ArrayList<Integer>();

        public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
            if (root == null) return listAll;
            list.add(root.val);
            target -= root.val;
            if (target == 0 && root.left == null && root.right == null)
                listAll.add(new ArrayList<Integer>(list));
            FindPath(root.left, target);
            FindPath(root.right, target);
            list.remove(list.size() - 1);
            return listAll;
        }
    }

    public static void main(String[] args) {
        TreeNodeFactory fac = TreeNodeFactory.getInstance();
        TreeNode root = fac.createTreeNode(1);
        root.left = fac.createTreeNode(2);
        root.right = fac.createTreeNode(2);
        root.left.left = fac.createTreeNode(4);
        root.left.right = fac.createTreeNode(2);
        root.right.right = fac.createTreeNode(1);
        root.right.left = fac.createTreeNode(2);
        Solution solution = new Solution();
        ArrayList<ArrayList<Integer>> lists = solution.FindPath(root, 4);
        System.out.println(lists.size());
        ArrayList<Integer> list = lists.get(0);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
