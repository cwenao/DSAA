/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

import com.cwenao.leetcode.algs.first.BuildTreeByPreAndInOrder.TreeNode;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id BuildTreeByInAndPostOrder.java, v1.0.0 2020-12-28 15:32 cwenao Exp $$
 */
public class BuildTreeByInAndPostOrder {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inStart = 0, inEnd = inorder.length - 1;
        int postStart = 0, postEnd = postorder.length - 1;
        return buildTree(inorder, inStart, inEnd, postorder, postStart, postEnd);
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {

        if (inStart > inEnd) {
            return null;
        }

        int rootVal = postorder[postEnd];
        int index = 0;

        for (int i = inStart; i <= inEnd; i++) {
            if (rootVal == inorder[i]) {
                index = i;
                break;
            }
        }

        TreeNode root = new TreeNode(rootVal);
        int left = index - inStart;

        root.left = buildTree(inorder, inStart, index - 1,
                postorder, postStart, postStart + left - 1);

        root.right = buildTree(inorder, index + 1, inEnd,
                postorder, postStart + left, postEnd - 1);

        return root;
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
