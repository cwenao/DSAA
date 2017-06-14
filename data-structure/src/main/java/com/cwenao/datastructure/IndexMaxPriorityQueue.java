/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * 参考算法第4版
 * @author cwenao
 * @version $Id IndexMaxPriorityQueue.java, v 0.1 2017-06-04 13:26 cwenao Exp $$
 */
public class IndexMaxPriorityQueue<Key extends Comparable<Key>> implements Iterable<Integer> {

    private int n;
    private int[] pq;
    private int[] qp;
    private Key[] keys;

    public IndexMaxPriorityQueue(int max) {
        if (max < 0) {
            throw new IllegalArgumentException();
        }
        n = 0;
        keys = (Key[]) new Comparable[max + 1];
        pq = new int[max + 1];
        qp = new int[max + 1];

        for (int i =0 ;i<max ;i++) {
            qp[i] = -1;
        }
    }

    public void insert(int i, Key key) {
        if (contains(i)) {
            throw new IllegalArgumentException("The index is already in the pq");
        }
        n++;
        qp[i] = n;
        pq[n] = i;
        keys[i] = key;
        swim(n);
    }



    private void swim(int k) {
        while (k > 1 && less( k/ 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k,j);
            k = j;
        }
    }

    public int maxIndex() {
        if (n == 0) {
            throw new NoSuchElementException();
        }
        return pq[1];
    }

    public Key maxKey() {
        if (n == 0) {
            throw new NoSuchElementException();
        }
        return keys[pq[1]];
    }

    public int delMax() {
        if (n == 0) {
            throw new NoSuchElementException();
        }
        int min = pq[1];
        exch(1, n--);
        sink(1);

        qp[min] = -1;
        keys[min] = null;
        pq[n + 1] = -1;

        return min;
    }

    public Key keyOf(int i) {
        if (!contains(i)) {
            throw new NoSuchElementException();
        } else {
            return keys[i];
        }
    }

    public void changeKey(int i, Key key) {
        if (!contains(i)) {
            throw new NoSuchElementException();
        }
        keys[i] = key;
        swim(qp[i]);
        sink(qp[i]);
    }

    public void increaseKey(int i, Key key) {
        if (!contains(i)) {
            throw new NoSuchElementException();
        }
        if (keys[i].compareTo(key) >= 0) {
            throw new IllegalArgumentException();
        }
        keys[i] = key;
        swim(qp[i]);
    }

    public void decreaseKey(int i, Key key) {
        if (!contains(i)) {
            throw new NoSuchElementException();
        }
        if (keys[i].compareTo(key) >= 0) {
            throw new IllegalArgumentException();
        }
        keys[i] = key;
        sink(qp[i]);
    }

    public void delete(int i) {
        if (!contains(i)) {
            throw new NoSuchElementException();
        }
        int index = qp[i];
        exch(index, n--);
        swim(index);
        sink(index);
        keys[i] = null;
        qp[i] = -1;
    }

    private boolean less(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) < 0;
    }

    private void exch(int i, int j) {
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public boolean contains(int i) {
        return qp[i] != -1;
    }

    public int size() {
        return n;
    }






    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {
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
    public void forEach(Consumer<? super Integer> action) {

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
    public Spliterator<Integer> spliterator() {
        return null;
    }
}

