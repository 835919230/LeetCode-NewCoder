package com.leetcode;

/**
 * Created by 诚 on 2016/9/9.
 * @see @link http://www.nowcoder.com/practice/e08819cfdeb34985a8de9c4e6562e724?tpId=46&tqId=29030&rp=1&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 */
public class findMinimumPath {
    public int run(TreeNode root) {
        if(root==null)
            return 0;
        if(root.left==null&&root.right==null)
            return 1;
        if(root.left==null)
            return run(root.right)+1;
        if(root.right==null)
            return run(root.left)+1;
        //如果两边都有
        return Math.min(run(root.left),run(root.right))+1;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }
}
