/*
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure.tree;

import java.io.Serializable;

/**
 * @author cwenao
 * @version $Id AVLNode.java, v 0.1 2017-08-03 00:14 cwenao Exp $$
 */
public class AVLNode<T extends Comparable> implements Serializable {

    private T data;
    private int high;
    private AVLNode<T> leftNode;
    private AVLNode<T> rightNode;

    public AVLNode(T data) {
        this(data, 0, null, null);
    }

    public AVLNode(T data, int high, AVLNode<T> leftNode, AVLNode<T> rightNode) {
        this.data = data;
        this.high = high;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public AVLNode<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(AVLNode<T> leftNode) {
        this.leftNode = leftNode;
    }

    public AVLNode<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(AVLNode<T> rightNode) {
        this.rightNode = rightNode;
    }
}
