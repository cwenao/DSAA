/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure.tree;

/**
 * @author cwenao
 * @version $Id RBTNode.java, v 0.1 2017-08-06 10:49 cwenao Exp $$
 */
public class RBTNode<T extends Comparable> {

    private T data;
    private boolean color;
    private RBTNode<T> leftNode;
    private RBTNode<T> rightNode;
    private RBTNode<T> parent;

    public RBTNode(T data) {
        this(data, true);
    }

    public RBTNode(T data, boolean color) {
        this(data, color, null, null,null);
    }

    public RBTNode(T data, boolean color, RBTNode<T> leftNode, RBTNode<T> rightNode,RBTNode<T> parent) {
        this.data = data;
        this.color = color;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.parent = parent;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public RBTNode<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(RBTNode<T> leftNode) {
        this.leftNode = leftNode;
    }

    public RBTNode<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(RBTNode<T> rightNode) {
        this.rightNode = rightNode;
    }

    public RBTNode<T> getParent() {
        return parent;
    }

    public void setParent(RBTNode<T> parent) {
        this.parent = parent;
    }
}
