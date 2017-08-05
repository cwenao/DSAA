/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying.linkedlist;

/**
 * @author cwenao
 * @version $Id LinkedNode.java, v 0.1 2017-08-05 10:01 cwenao Exp $$
 */
public class LinkedNode<T extends Comparable> {
    private T data;
    private LinkedNode<T> next;

    public LinkedNode(T data){
        this(data, null);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LinkedNode<T> getNext() {
        return next;
    }

    public void setNext(LinkedNode<T> next) {
        this.next = next;
    }

    public LinkedNode(T data, LinkedNode<T> next) {
        this.data = data;
        this.next = next;
    }

}
