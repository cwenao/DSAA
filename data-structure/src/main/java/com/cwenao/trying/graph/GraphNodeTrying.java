/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying.graph;

/**
 * @author cwenao
 * @version $Id GraphNodeTrying.java, v 0.1 2017-10-11 10:27 cwenao Exp $$
 */
public class GraphNodeTrying<T>  {
    private T item;
    private GraphNodeTrying<T> next;

    public GraphNodeTrying() {
        this(null);
    }

    public GraphNodeTrying(T item) {
        this(item, null);
    }

    public GraphNodeTrying(T item, GraphNodeTrying next) {
        this.item = item;
        this.next = next;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public GraphNodeTrying<T> getNext() {
        return next;
    }

    public void setNext(GraphNodeTrying<T> next) {
        this.next = next;
    }
}


