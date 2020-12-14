/*
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure.sort;

/**
 * @author cwenao
 * @version $Id HeapSort.java, v 0.1 2017-08-13 16:12 cwenao Exp $$
 */
public class HeapSort {


    public void heapSortAES(int[] array) {
        int len = array.length;

        for (int i = len / 2-1; i > 0; i--) {
            heapSink(array, i, len);
        }

        for (int i = len - 1; i > 0; i--) {
            exch(array, 1, i);
            heapSink(array, 1, i - 1);
        }

    }

    private void heapSink(int[] array, int k, int len) {

        while (2 * k <= len) {
            int j = 2 * k;
            if (j < len && !less(array, j, j + 1)) {
                j++;
            }
            if (less(array, k, j)) {
                break;
            }
            exch(array, k, j);
            k = j;
        }
    }

    private boolean less(int[] array, int source, int target) {
        return array[source] < array[target];
    }

    private void exch(int[] array, int source, int target) {
        int tmp = array[source];
        array[source] = array[target];
        array[target] = tmp;
    }

    public static void main(String[] args) {
        int array[] = {0,25,30,95,41,72,130,71,10,110,52,80};
        HeapSort heapSort = new HeapSort();
        heapSort.heapSortAES(array);
        for (int x : array) {
            System.out.println("this is the elements: " + x);
        }
    }

}
