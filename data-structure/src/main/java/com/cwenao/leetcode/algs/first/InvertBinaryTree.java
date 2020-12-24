/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id InvertBinaryTree.java, v1.0.0 2020-12-24 08:46 cwenao Exp $$
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {

        return invertTreeByRecursive(root);

    }

    private TreeNode invertTreeByRecursive(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTreeByRecursive(root.left);
        invertTreeByRecursive(root.right);

        return root;
    }

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
