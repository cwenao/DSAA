/**
 * Company Copyright (C) 2014-2019 All Rights Reserved.
 */
package com.cwenao.leetcode.hundred.first;

import jdk.nashorn.internal.objects.annotations.Getter;

/**
 *
 * TODO : Statement the class description
 * @author cwenao
 * @version $Id TreeNode.java, v1.0.0 2019-06-30 17:23 cwenao Exp $$
 */
public class TreeNode {

    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(){}

    TreeNode(int value) {
        this.value = value;
    }

    TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
