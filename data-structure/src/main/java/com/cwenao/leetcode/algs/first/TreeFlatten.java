/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id TreeFlatten.java, v1.0.0 2020-12-17 15:53 cwenao Exp $$
 */
public class TreeFlatten {


    /**
     * 后序遍历
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        //将left下的right节点移到当前节点下
        while (root.right != null) {
            root = root.right;
        }
        //最后将原始right节点挂载到当前right节点下
        root.right = right;
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
