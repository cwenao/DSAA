/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying.tree;

/**
 * @author cwenao
 * @version $Id RBTNodeTrying.java, v 0.1 2017-11-06 08:40 cwenao Exp $$
 */
public class RBTNodeTrying<T extends Comparable> {

    private T data;
    private boolean color;
    private RBTNodeTrying<T> left;
    private RBTNodeTrying<T> right;
    private int size;

    public RBTNodeTrying(T data) {
        this(data, true);
    }

    public RBTNodeTrying(T data, boolean color) {
        this(data, color, null, null);
    }

    public RBTNodeTrying(T data, boolean color, RBTNodeTrying<T> left, RBTNodeTrying<T> right) {
        this.data = data;
        this.color = color;
        this.left = left;
        this.right = right;
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

    public RBTNodeTrying<T> getLeft() {
        return left;
    }

    public void setLeft(RBTNodeTrying<T> left) {
        this.left = left;
    }

    public RBTNodeTrying<T> getRight() {
        return right;
    }

    public void setRight(RBTNodeTrying<T> right) {
        this.right = right;
    }
}
