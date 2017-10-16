/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying.tree;

import java.io.Serializable;

/**
 * @author cwenao
 * @version $Id BinaryNodeTrying.java, v 0.1 2017-10-16 16:45 cwenao Exp $$
 */
public class BinaryNodeTrying<T extends Comparable> implements Serializable {
    private int data;
    private BinaryNodeTrying<T> leftNode;
    private BinaryNodeTrying<T> rightNode;

    public BinaryNodeTrying(int data) {
        this(data, null, null);
    }
    public BinaryNodeTrying(int data, BinaryNodeTrying leftNode, BinaryNodeTrying rightNode) {
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinaryNodeTrying<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BinaryNodeTrying<T> leftNode) {
        this.leftNode = leftNode;
    }

    public BinaryNodeTrying<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(BinaryNodeTrying<T> rightNode) {
        this.rightNode = rightNode;
    }
}
