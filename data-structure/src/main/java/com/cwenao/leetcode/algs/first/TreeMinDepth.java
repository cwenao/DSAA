/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

import java.util.LinkedList;
import java.util.Queue;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id TreeMinDepth.java, v1.0.0 2020-12-13 07:44 cwenao Exp $$
 */
public class TreeMinDepth {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return minDepthByBFS(root);
    }

    private int minDepthByBFS(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 1;
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();
                if (currNode.left == null && currNode.right== null) {
                    return depth;
                }

                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
            depth++;
        }
        return depth;
    }

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}

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
