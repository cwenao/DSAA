/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.second;

import java.util.LinkedList;
import java.util.Queue;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id TreeMinDepth.java, v1.0.0 2021-03-18 09:54 cwenao Exp $$
 */
public class TreeMinDepth {

    public int minDepth(TreeNode node){

        if (node == null) {
            return 0;
        }

        return minDepthByBFS(node);
    }

    private int minDepthByBFS(TreeNode node) {

        Queue<TreeNode> bfsQueue = new LinkedList<>();

        int depth = 1;
        bfsQueue.offer(node);

        while (!bfsQueue.isEmpty()) {

            int size = bfsQueue.size();

            for (int i = 0; i < size; i++) {
                TreeNode treeNode = bfsQueue.poll();
                if (treeNode.left == null && treeNode.right == null) {
                    return depth;
                }
                if (treeNode.left != null) {
                    bfsQueue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    bfsQueue.offer(treeNode.right);
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
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
