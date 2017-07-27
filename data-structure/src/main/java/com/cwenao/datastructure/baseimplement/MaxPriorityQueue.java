/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure.baseimplement;

import java.util.*;

/**
 * @author cwenao
 * @version $Id MaxPriorityQueue.java, v 0.1 2017-05-17 10:35 cwenao Exp $$
 */
public class MaxPriorityQueue<Key> implements Iterable<Key>{

    private Key[] pq;
    private int n;
    private Comparator<Key> comparator;


    public MaxPriorityQueue() {
        this(1);
    }

    public MaxPriorityQueue(int initCapacity) {
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    public MaxPriorityQueue(Comparator<Key> comparator) {
        this(1, comparator);
    }

    public MaxPriorityQueue(int initCapacity, Comparator<Key> comparator) {
        this.comparator = comparator;
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    public MaxPriorityQueue(Key[] keys) {
        n = keys.length;
        pq = (Key[]) new Object[keys.length + 1];

        for(int i =0;i<n;i++) {
            pq[i + 1] = keys[i];
        }
        for(int k =n/2;k>=1;k--) {
            sink(k);
        }

    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public Key max() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue underflow");
        }
        return pq[1];
    }

    public void resize(int initCapacity) {
        Key[] temp = (Key[]) new Object[initCapacity + 1];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    public void insert(Key x) {
        if (n >= pq.length - 1) {
            resize(2 * pq.length);
        }

        pq[++n] = x;
        swim(n);
    }

    public Key delMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue underflow");
        }
        Key max = pq[1];
        exch(1, n--);
        sink(1);
        pq[n + 1] = null;
        if (n > 0 && n == (pq.length - 1) / 4) {
            resize(pq.length / 2);
        }
        return max;
    }

    private boolean less(int i, int j) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) < 0;
        } else {
            return comparator.compare(pq[i], pq[j]) < 0;
        }
    }

    private void exch(int i, int j) {
        Key swap = pq[i];

        pq[i] = pq[j];
        pq[j] = swap;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j, j + 1)) {
                j++;
            }
            if (less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    //TODO to implement the method
    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Key> iterator() {
        return null;
    }

    private class HeapIterator implements Iterator<Key>{
        private MaxPriorityQueue<Key> copy;

        public HeapIterator() {
            if (comparator == null) {
                copy = new MaxPriorityQueue<Key>(size());
            } else {
                copy = new MaxPriorityQueue<Key>(size(), comparator);
            }

            for(int i=0;i<=n;i++) {
                copy.insert(pq[i]);
            }
        }

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return !copy.isEmpty();
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public Key next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return copy.delMax();
        }

        /**
         * Removes from the underlying collection the last element returned
         * by this iterator (optional operation).  This method can be called
         * only once per call to {@link #next}.  The behavior of an iterator
         * is unspecified if the underlying collection is modified while the
         * iteration is in progress in any way other than by calling this
         * method.
         *
         * @throws UnsupportedOperationException if the {@code remove}
         *                                       operation is not supported by this iterator
         * @throws IllegalStateException         if the {@code next} method has not
         *                                       yet been called, or the {@code remove} method has already
         *                                       been called after the last call to the {@code next}
         *                                       method
         * @implSpec The default implementation throws an instance of
         * {@link UnsupportedOperationException} and performs no other action.
         */
        @Override
        public void remove() {

        }

    }

    public static void main(String[] args) {

        MaxPriorityQueue<Integer> maxPQ = new MaxPriorityQueue<>();
        int[] pqs = new int[]{1, 5, 6, 2, 110, 55, 33, 0};

        for (int i =0;i<pqs.length;i++) {
            maxPQ.insert(pqs[i]);
        }

        System.out.println(maxPQ.size());

    }

}

