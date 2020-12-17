/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;


/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id deleteNodeByBST.java, v1.0.0 2020-12-17 17:22 cwenao Exp $$
 */
public class deleteNodeByBST {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            TreeNode rightMinNode = minNode(root.right);
            root.val = rightMinNode.val;
            root.right = deleteNode(root.right, rightMinNode.val);
        }

        if (key > root.val) {
            root.right = deleteNode(root.right,key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

    private TreeNode minNode(TreeNode right) {
        if (right.left == null) {
            return right;
        }
        return minNode(right.left);
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
