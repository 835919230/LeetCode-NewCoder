package com.sword;

import com.common.TreeNode;

import java.util.HashMap;

/**
 * Created by 诚 on 2016/9/10.
 */
public class ReconstructTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i],i);
        }
        return preIn(pre,0,pre.length-1,in,0,in.length-1,map);
    }

    private TreeNode preIn(int[] pre, int pi, int pj,
                          int[] in, int ni, int nj,
                          HashMap<Integer, Integer> map)
    {
        if (pi > pj)
            return null;
        TreeNode head = new TreeNode(pre[pi]);
        int index = map.get(pre[pi]);
        head.left = preIn(pre, pi + 1, pi + index - ni,
                            in, ni, index - 1,
                            map);
        head.right = preIn(pre, pi + index - ni + 1, pj,
                            in, index + 1, nj,
                            map);
        return head;
    }
}
