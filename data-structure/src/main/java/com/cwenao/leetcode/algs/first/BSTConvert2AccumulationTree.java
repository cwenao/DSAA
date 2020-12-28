/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

import com.cwenao.leetcode.algs.first.BSTKthSmallest.TreeNode;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id BSTConvert2AccumulationTree.java, v1.0.0 2020-12-28 23:22 cwenao Exp $$
 */
public class BSTConvert2AccumulationTree {

    int sumNodeVal = 0;

    public TreeNode convertBST(TreeNode root) {

        return convertBSTByInOrder(root);
    }
    //倒序排列
    private TreeNode convertBSTByInOrder(TreeNode node) {
        if (node == null) {
            return null;
        }

        convertBSTByInOrder(node.right);
        //当前节点的值为：大于等于当前值的总和
        sumNodeVal += node.val;
        node.val = sumNodeVal;

        convertBSTByInOrder(node.left);

        return node;
    }


    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
