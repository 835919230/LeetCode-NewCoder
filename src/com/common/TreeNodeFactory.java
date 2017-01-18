package com.common;

/**
 * Created by HeXi on 2017/1/18.
 */
public class TreeNodeFactory {

    private TreeNodeFactory() {
    }

    private static TreeNodeFactory factory;

    public static TreeNodeFactory getInstance() {
        if (factory == null) {
            synchronized (TreeNodeFactory.class) {
                if (factory == null) {
                    factory = new TreeNodeFactory();
                }
            }
        }

        return factory;
    }

    public TreeNode createTreeNode() {
        return createTreeNode(0);
    }

    public TreeNode createTreeNode(int val) {
        return new TreeNode(val);
    }
}
