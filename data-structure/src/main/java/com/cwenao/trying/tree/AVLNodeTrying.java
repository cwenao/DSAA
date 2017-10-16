/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying.tree;

import java.io.Serializable;

/**
 * @author cwenao
 * @version $Id AVLNodeTrying.java, v 0.1 2017-10-15 16:26 cwenao Exp $$
 */
public class AVLNodeTrying<T extends Comparable> implements Serializable {

    private T data;
    private int high;
    private AVLNodeTrying<T> leftNode;
    private AVLNodeTrying<T> rightNode;

    public AVLNodeTrying(T data) {
        this(data, 0, null, null);
    }

    public AVLNodeTrying(T data, int high, AVLNodeTrying<T> leftNode, AVLNodeTrying<T> rightNode) {
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

    public AVLNodeTrying<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(AVLNodeTrying<T> leftNode) {
        this.leftNode = leftNode;
    }

    public AVLNodeTrying<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(AVLNodeTrying<T> rightNode) {
        this.rightNode = rightNode;
    }
}
