/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure.tree;

import java.io.Serializable;

/**
 * @author cwenao
 * @version $Id BinaryNode.java, v 0.1 2017-07-27 23:57 cwenao Exp $$
 */
public class BinaryNode<T extends Comparable> implements Serializable {

    private T data;

    private BinaryNode<T> leftNode;

    private BinaryNode<T> rightNode;

    public BinaryNode(T data) {
        this(data, null, null);
    }

    public BinaryNode(T data, BinaryNode<T> leftNode, BinaryNode<T> rightNode) {
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    /**
     * To judge this node is the leaf node
     * @return
     */
    public boolean isLeafNode() {
        return this.leftNode == null && this.rightNode == null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinaryNode<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BinaryNode<T> leftNode) {
        this.leftNode = leftNode;
    }

    public BinaryNode<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(BinaryNode<T> rightNode) {
        this.rightNode = rightNode;
    }
}
