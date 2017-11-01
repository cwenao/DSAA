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



    private boolean less(int i, int j) {
        return heaps[i].compareTo(heaps[j]) < 0;
    }

    private void exch(int i, int j) {
        T tmp = heaps[i];
        heaps[i] = heaps[j];
        heaps[j] = tmp;
    }

}
