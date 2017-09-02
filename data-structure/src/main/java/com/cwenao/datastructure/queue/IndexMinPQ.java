/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure.queue;

import java.util.Iterator;

/** 索引优先队列：在优先队列的基础上加上优先队列中值在qp中对应的索引
 *
 * @author cwenao
 * @version $Id IndexMinPQ.java, v 0.1 2017-09-02 23:33 cwenao Exp $$
 */
public class IndexMinPQ<T extends Comparable> implements Iterable{

    private int maxLen; //PQ的最大长度
    private static final int DEFAULT_MAX_LEN = 20;
    private int len; //PQ长度
    private int pq[]; // 优先队列
    private int qp[]; // 优先队列值映射列表
    private T[] keys; // 真实元素队列

    public IndexMinPQ() {
        this(DEFAULT_MAX_LEN);
    }

    public IndexMinPQ(int maxLen) {
        this.maxLen = maxLen;
        pq = new int[maxLen + 1];
        qp = new int[maxLen + 1];
        keys = (T[]) new Comparable[maxLen + 1];
        len = 0;

        for (int i=0;i<=maxLen;i++) {
            qp[i] = -1;
        }
    }

    private void swim(int k) {
        while (k > 1 && greater(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= len) {
            int j = 2 * k;
            if (j < len && greater(j, j + 1)) {
                j++;
            }
            if (!greater(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    private boolean greater(int source, int target) {
        return keys[pq[source]].compareTo(keys[pq[target]]) > 0;
    }

    private void exch(int source, int target) {
        int tmp = pq[source];
        pq[source] = pq[target];
        pq[target] = tmp;
        qp[pq[source]] = source;
        qp[pq[target]] = target;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

}
