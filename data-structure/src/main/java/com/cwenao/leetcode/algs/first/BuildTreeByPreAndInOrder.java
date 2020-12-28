/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id BuildTreeByPreAndInOrder.java, v1.0.0 2020-12-28 08:14 cwenao Exp $$
 */
public class BuildTreeByPreAndInOrder {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preStart = 0, preEnd = preorder.length-1;
        int inStart = 0, inEnd = inorder.length-1;
        return buildTreeByRecursive(preorder, preStart, preEnd, inorder, inStart, inEnd);
    }

    private TreeNode buildTreeByRecursive(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {

        if (preStart > preEnd) {
            return null;
        }

        int index = 0;
        //前序遍历，第一个节点为root
        int rootVal = preorder[preStart];

        for (int i = inStart; i <= inEnd; i++) {
            if (rootVal == inorder[i]) {
                index = i;
                break;
            }
        }

        TreeNode root = new TreeNode(rootVal);
        //root节点左边长度
        int left = index - inStart;

        root.left = buildTreeByRecursive(preorder, preStart + 1, preStart + left,
                inorder, inStart, index - 1);

        root.right = buildTreeByRecursive(preorder, preStart + left + 1, preEnd,
                inorder, index + 1, inEnd);

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
