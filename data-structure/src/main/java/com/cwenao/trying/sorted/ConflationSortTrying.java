/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying.sorted;

/**
 * GET
 * @author cwenao
 * @version $Id ConflationSortTrying.java, v 0.1 2017-10-14 13:57 cwenao Exp $$
 */
public class ConflationSortTrying {

    private static void mergeAsc(int[] sortedArray, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int x = 0;
        int[] temp = new int[high - low + 1];

        while (i <= mid && j <= high) {
            if (sortedArray[i] <= sortedArray[j]) {
                temp[x++] = sortedArray[i++];
            } else {
                temp[x++] = sortedArray[j++];
            }
        }
        while (i <= mid) {
            temp[x++] = sortedArray[i++];
        }
        while (j <= high) {
            temp[x++] = sortedArray[j++];
        }

        for (int k = 0; k < temp.length; k++) {
            sortedArray[low + k] = temp[k];
        }
    }

    private static void conflation(int[] sortedArray, int low, int high) {

        if (low < high) {
            int mid = (high + low) / 2;
            conflation(sortedArray, low, mid);
            conflation(sortedArray, mid + 1, high);
            mergeAsc(sortedArray, low, mid, high);
        }
    }

    public static void main(String[] args) {
        int[] shellArray = new int[]{10, 8, 11, 2, 6, 99, 1, 100, 104, 55, 3, 4, 44, 108, 300, 33};
        conflation(shellArray, 0, shellArray.length - 1);
        for (int i : shellArray) {
            System.out.println(i);
        }
    }
}
