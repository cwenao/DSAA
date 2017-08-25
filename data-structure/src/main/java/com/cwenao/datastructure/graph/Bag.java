/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure.graph;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Bag is
 * @author cwenao
 * @version $Id Bag.java, v 0.1 2017-08-12 14:33 cwenao Exp $$
 */
public class Bag<T> implements Iterable<T> {

    private GraphNode<T> first;
    private int n;

    public Bag() {
        first = null;
        n = 0;
    }

    public void add(T data) {
        GraphNode<T> oldFirst = first;
        first = new GraphNode<T>(data);
        first.setData(data);
        first.setNext(oldFirst);
        n++;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }


    @Override
    public Iterator<T> iterator() {
        return new ListIterator(first);
    }

    private class ListIterator<T extends Comparable> implements Iterator<T> {
        private GraphNode<T> currentNode;

        public ListIterator(GraphNode<T> first) {
            currentNode = first;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T data = currentNode.getData();
            currentNode = currentNode.getNext();

            return data;
        }
    }
}
