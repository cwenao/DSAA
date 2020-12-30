/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id CountNodesForTree.java, v1.0.0 2020-12-30 08:49 cwenao Exp $$
 */
public class CountNodesForTree {

    public int countNodes(TreeNode root) {
        return countNodesByRecursive(root);
    }

    private int countNodesByRecursive(TreeNode node) {
        if (node == null) {
            return 0;
        }

        TreeNode leftNode = node, rightNode = node;
        int left = 0, right = 0;

        //统计左右子树深度
        while (leftNode != null) {
            leftNode = leftNode.left;
            left++;
        }

        while (rightNode != null) {
            rightNode = rightNode.right;
            right++;
        }
        if (left == right) {
            //leftNode == rightNode init为node
            //总数需要-1
            return (int) (Math.pow(2, left)) - 1;
        }

        return countNodesByRecursive(node.left) + countNodesByRecursive(node.right) + 1;
    }


    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
