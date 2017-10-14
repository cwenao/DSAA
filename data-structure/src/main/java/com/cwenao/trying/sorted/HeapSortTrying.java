/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying.sorted;

/**
 * Get
 * 1. 建堆： len/2处开始建立堆
 * 2. 调整堆： 第一个元素与无需堆最后一个调换，再建立堆
 * @author cwenao
 * @version $Id HeapSortTrying.java, v 0.1 2017-10-14 14:50 cwenao Exp $$
 */
public class HeapSortTrying {

    public static void heapSort(int[] sortedArray) {
        int len = sortedArray.length;

        for (int i = len / 2 - 1; i > 0; i--) {
            heapSink(sortedArray, i, len);
        }

        for (int i = len - 1; i > 0; i--) {
            exch(sortedArray, 1, i);
            heapSink(sortedArray, 1, i - 1);
        }

    }

    private static void heapSink(int[] sortedArray, int k, int len) {

        while (2 * k <= len) {
            int j = 2 * k;
            if (j < len && !less(sortedArray, j, j + 1)) {
                j++;
            }
            if (less(sortedArray, k, j)) {
                break;
            }
            exch(sortedArray, k, j);
            k = j;
        }
    }

    private static boolean less(int[] sortedArray, int i, int j) {
        return sortedArray[i] < sortedArray[j];
    }

    private static void exch(int[] sortedArray, int i, int j) {
        int temp = sortedArray[i];
        sortedArray[i] = sortedArray[j];
        sortedArray[j] = temp;
    }

    public static void main(String[] args) {
        int[] shellArray = new int[]{-99999,10, 8, 11, 2, 6, 99, 1, 100, 104, 55, 3, 4, 44, 108, 300, 33};
        heapSort(shellArray);

        for (int x : shellArray) {
            System.out.println(x);
        }

    }

}
