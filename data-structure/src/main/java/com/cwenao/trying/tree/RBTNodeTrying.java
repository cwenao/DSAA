/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying.tree;

/**
 * @author cwenao
 * @version $Id RBTNodeTrying.java, v 0.1 2017-11-06 08:40 cwenao Exp $$
 */
public class RBTNodeTrying<Key extends Comparable<Key> ,Value> {

    private Key key;
    private Value value;
    private boolean color;
    private RBTNodeTrying<Key,Value> left;
    private RBTNodeTrying<Key,Value> right;
    private int size;

    public RBTNodeTrying(Key key, Value value) {
        this(key, value,true);
    }

    public RBTNodeTrying(Key key,Value value, boolean color) {
        this(key, value, color, null, null);
    }

    public RBTNodeTrying(Key key,Value value, boolean color, RBTNodeTrying left, RBTNodeTrying right) {
        this.key = key;
        this.value = value;
        this.color = color;
        this.left = left;
        this.right = right;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public RBTNodeTrying<Key, Value> getLeft() {
        return left;
    }

    public void setLeft(RBTNodeTrying<Key, Value> left) {
        this.left = left;
    }

    public RBTNodeTrying<Key, Value> getRight() {
        return right;
    }

    public void setRight(RBTNodeTrying<Key, Value> right) {
        this.right = right;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
