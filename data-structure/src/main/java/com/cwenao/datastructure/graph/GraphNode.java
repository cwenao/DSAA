/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure.graph;

/**
 * @author cwenao
 * @version $Id GraphNode.java, v 0.1 2017-08-12 14:21 cwenao Exp $$
 */
public class GraphNode<T extends Comparable> {

    private T data;
    private GraphNode<T> next;

    public GraphNode(T data) {
        this(data, null);
    }

    public GraphNode(T data, GraphNode<T> node) {
        this.data = data;
        this.next = node;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public GraphNode<T> getNext() {
        return next;
    }

    public void setNext(GraphNode<T> next) {
        this.next = next;
    }
}
