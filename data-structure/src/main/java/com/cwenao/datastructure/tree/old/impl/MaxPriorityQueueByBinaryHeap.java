/*
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure.tree.old.impl;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * 基于完全二叉树
 * 其第一个位置0不用于存储
 * 所以k位置的父节点为k/2
 * @author cwenao
 * @version $Id MaxPriorityQueueByBinaryHeap.java, v 0.1 2017-07-30 17:54 cwenao Exp $$
 */
public class MaxPriorityQueueByBinaryHeap<Key extends Comparable<Key>> implements Iterable<Key>{

    private Key[] pQueue;
    private int n;

    public MaxPriorityQueueByBinaryHeap() {
        this(1);
    }

    public MaxPriorityQueueByBinaryHeap(int initCapacity) {
        pQueue = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    /**
     * 插入
     * @param x
     */
    public void insert(Key x) {
        if (n >= pQueue.length - 1) {
            resize(2 * pQueue.length);
        }
        pQueue[++n] = x;
        swim(n);
    }

    /**
     * 删除最大值
     * @return
     */
    public Key delMax() {
        Key tmp = pQueue[1];
        exchange(1, n--);
        sink(1);
        pQueue[n + 1] = null;

        return tmp;
    }

    /**
     * 从下至上恢复堆得有序性
     * k位置的父节点为k/2
     * @param k
     */
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exchange(k / 2, k);
            k = k / 2;
        }
    }

    /**
     * 从上至下的恢复堆得有序性
     * k位置的子节点位置分别为 2*k,2*k+1
     * @param k
     */
    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j, j + 1)) {
                j++;
            }
            if (less(k, j)) {
                break;
            }
            exchange(k, j);
            k = j;
        }
    }

    private void exchange(int source, int target) {
        Key tmp = pQueue[source];
        pQueue[source] = pQueue[target];
        pQueue[target] = tmp;
    }

    private boolean less(int source, int target) {
        return pQueue[source].compareTo(pQueue[target]) < 0;
    }

    private void resize(int initCapacity) {
        Key[] tmp = (Key[]) new Object[initCapacity + 1];
        for (int i = 0;i<=n;i++) {
            tmp[i] = pQueue[i];
        }
        pQueue = tmp;
    }

    public Key max() {
        return pQueue[1];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }



    @Override
    public Iterator<Key> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super Key> action) {

    }

    @Override
    public Spliterator<Key> spliterator() {
        return null;
    }
}
