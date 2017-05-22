/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure;

import java.util.*;
import java.util.function.Consumer;

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

    /**
     * Performs the given action for each element of the {@code Iterable}
     * until all elements have been processed or the action throws an
     * exception.  Unless otherwise specified by the implementing class,
     * actions are performed in the order of iteration (if an iteration order
     * is specified).  Exceptions thrown by the action are relayed to the
     * caller.
     *
     * @param action The action to be performed for each element
     * @throws NullPointerException if the specified action is null
     * @implSpec <p>The default implementation behaves as if:
     * <pre>{@code
     *     for (T t : this)
     *         action.accept(t);
     * }</pre>
     * @since 1.8
     */
    @Override
    public void forEach(Consumer<? super Key> action) {

    }

    /**
     * Creates a {@link Spliterator} over the elements described by this
     * {@code Iterable}.
     *
     * @return a {@code Spliterator} over the elements described by this
     * {@code Iterable}.
     * @implSpec The default implementation creates an
     * <em><a href="Spliterator.html#binding">early-binding</a></em>
     * spliterator from the iterable's {@code Iterator}.  The spliterator
     * inherits the <em>fail-fast</em> properties of the iterable's iterator.
     * @implNote The default implementation should usually be overridden.  The
     * spliterator returned by the default implementation has poor splitting
     * capabilities, is unsized, and does not report any spliterator
     * characteristics. Implementing classes can nearly always provide a
     * better implementation.
     * @since 1.8
     */
    @Override
    public Spliterator<Key> spliterator() {
        return null;
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

