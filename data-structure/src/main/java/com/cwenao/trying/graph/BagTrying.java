/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying.graph;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author cwenao
 * @version $Id BagTrying.java, v 0.1 2017-10-11 10:37 cwenao Exp $$
 */
public class BagTrying<T> implements Iterable<T> {

    private int n;
    private GraphNodeTrying<T> first;

    public BagTrying() {
        n = 0;
        first = null;
    }

    public void add(T item) {
        GraphNodeTrying<T> older = first;
        first = new GraphNodeTrying<T>();
        first.setItem(item);
        first.setNext(older);
        n++;
    }

    public int size() {
        return n;
    }

    private class ListIterator<T> implements Iterator<T> {

        private GraphNodeTrying<T> current;

        public ListIterator(GraphNodeTrying<T> first) {
            current = first;
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T t = current.getItem();
            current = current.getNext();
            return t;
        }

        public boolean hasNext() {
            return current != null;
        }
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator<>(first);
    }

}
