/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying.array;

/**
 * @author cwenao
 * @version $Id FindMinimunForSortedAndRotated.java, v 0.1 2017-08-02 23:54 cwenao Exp $$
 */
public class FindMinimunForSortedAndRotated {

    public int findMinimun(int[] array, int low, int high) {

        if (low > high) {
            return array[0];
        }

        if (low == high) {
            return array[0];
        }

        int mid = (high - low) / 2 + low;

        if (mid < high && array[mid] > array[mid + 1]) {
            return array[mid + 1];
        }
        if (mid > low && array[mid] < array[mid - 1]) {
            return array[mid];
        }

        if (array[high] > array[mid]) {
            return findMinimun(array, low, mid - 1);
        }

        return findMinimun(array, mid + 1, high);
    }

    public static void main(String[] args) {
        int[] array = {15, 18, 2, 3, 6, 12};
        FindMinimunForSortedAndRotated findMinimunForSortedAndRotated = new FindMinimunForSortedAndRotated();
        int minimun = findMinimunForSortedAndRotated.findMinimun(array, 0, array.length - 1);
        System.out.println(minimun);
    }

}
