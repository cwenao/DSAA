/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure.queue;

import java.util.Iterator;

/**
 * @author cwenao
 * @version $Id MinPQ.java, v 0.1 2017-08-30 23:13 cwenao Exp $$
 */
public class MinPQ<T extends Comparable> implements Iterable {

    private T[] pq;
    private int len;

    public MinPQ() {
        this(1);
        len = 0;
    }

    public MinPQ(int initCapacity) {
        pq = (T[]) new Object[initCapacity + 1];
    }

    private void exch(int i, int j) {
        T tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = pq[i];
    }

    private boolean greater(int i, int j) {
        return pq[i].compareTo(pq[j]) > 0;
    }

    private void swim(int k) {
        while (k > 1 && greater(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= len) {
            int nextNode = 2 * k;
            if (nextNode < len && greater(nextNode, nextNode + 1)) {
                nextNode++;
            }
            if (!greater(k, nextNode)) {
                break;
            }
            exch(k, nextNode);
            k = nextNode;
        }
    }

    public void insert(T value) {
        pq[++len] = value;
        swim(len);
    }

    public T delMin() {
        T tmp = pq[1];
        exch(1, len--);
        sink(1);
        pq[len + 1] = null;
        return tmp;
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public int size() {
        return len;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    private class HeapIterator implements Iterator<T> {

        private MinPQ<T> cloneMinPQ;

        public HeapIterator() {
            cloneMinPQ = new MinPQ<>(size());
            for(int x=1;x<=len;x++) {
                cloneMinPQ.insert(pq[x]);
            }
        }

        @Override
        public boolean hasNext() {

            return !cloneMinPQ.isEmpty();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                return null;
            }
            return cloneMinPQ.delMin();
        }
    }

}
