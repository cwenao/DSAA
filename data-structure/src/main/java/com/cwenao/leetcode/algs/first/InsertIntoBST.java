/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;


/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id InsertIntoBST.java, v1.0.0 2020-12-17 17:05 cwenao Exp $$
 */
public class InsertIntoBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) {
            return new TreeNode(val);
        }
        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        } else if (val < root.val){
            root.left = insertIntoBST(root.left, val);
        }
        return root;
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
