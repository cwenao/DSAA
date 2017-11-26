/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying.stackandqueue;

/**
 * @author cwenao
 * @version $Id QueueNode.java, v 0.1 2017-11-26 06:55 cwenao Exp $$
 */
public class QueueNode<T extends Comparable> {
    private QueueNode<T> root;
    private T data;
    private QueueNode<T> next;

    public QueueNode<T> getRoot() {
        return root;
    }

    public void setRoot(QueueNode<T> root) {
        this.root = root;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public QueueNode<T> getNext() {
        return next;
    }

    public void setNext(QueueNode<T> next) {
        this.next = next;
    }
}
