/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id BSTkthSmallest.java, v1.0.0 2020-12-28 16:50 cwenao Exp $$
 */
public class BSTKthSmallest {

    public int kthSmallest(TreeNode root, int k) {
        return kthSmallestByInOrder(root, k);
    }

    private int kthSmallestByInOrder(TreeNode root, int k) {
        List<Integer> inOrderList = new ArrayList<>();
        inOrder(root, inOrderList);

        return inOrderList.get(k - 1);
    }

    private void inOrder(TreeNode node, List<Integer> inOrderList) {
        if (node == null) {
            return;
        }

        inOrder(node.left, inOrderList);
        inOrderList.add(node.val);
        inOrder(node.right, inOrderList);
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
