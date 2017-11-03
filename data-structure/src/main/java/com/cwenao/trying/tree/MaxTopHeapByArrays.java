/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying.tree;

/**
 * @author cwenao
 * @version $Id MaxTopHeapByArrays.java, v 0.1 2017-10-31 09:21 cwenao Exp $$
 */
public class MaxTopHeapByArrays<T extends Comparable> {

    private T[] heaps;

    private int n;




    /**
     * 下沉交换树上位置
     * @param k
     */
    private void sink(int k) {

        while (2 * k < n) {
            int j = 2 * k;
            if (j < 0 && less(j, j + 1)) {
                j++;
            }
            if (less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    /**
     * 上浮
     * @param k
     */
    private void swam(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private boolean less(int i, int j) {
        return heaps[i].compareTo(heaps[j]) < 0;
    }

    private void exch(int i, int j) {
        T tmp = heaps[i];
        heaps[i] = heaps[j];
        heaps[j] = tmp;
    }

}
