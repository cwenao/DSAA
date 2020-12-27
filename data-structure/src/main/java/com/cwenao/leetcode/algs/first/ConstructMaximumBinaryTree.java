/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id ConstructMaximumBinaryTree.java, v1.0.0 2020-12-27 09:20 cwenao Exp $$
 */
public class ConstructMaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructByRecursive(nums,0,nums.length);
    }

    private TreeNode constructByRecursive(int[] nums, int left, int right) {
        if (left == right) {
            return null;
        }

        int maxValueIndex = maxV(nums, left, right);

        TreeNode root = new TreeNode(nums[maxValueIndex]);
        root.left = constructByRecursive(nums, left, maxValueIndex);
        root.right = constructByRecursive(nums, maxValueIndex + 1, right);

        return root;
    }

    private int maxV(int[] nums, int left, int right) {
        int index = left;
        for (int i = left; i < right; i++) {
            if (nums[index] < nums[i]) {
                index = i;
            }
        }

        return index;
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
