/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id ValidBST.java, v1.0.0 2020-12-17 16:32 cwenao Exp $$
 */
public class ValidBST {

    public boolean isValidBST(TreeNode root) {

        return toValidBST(root, null, null);
    }

    private boolean toValidBST(TreeNode root, TreeNode maxVal, TreeNode minVal) {

        if (root == null) {
            return true;
        }

        if (maxVal != null && root.val >= maxVal.val) {
            return false;
        }
        if (minVal != null && root.val <= minVal.val) {
            return false;
        }

        return toValidBST(root.left, root, minVal) & toValidBST(root.right, maxVal, root);
    }


    class TreeNode{

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
