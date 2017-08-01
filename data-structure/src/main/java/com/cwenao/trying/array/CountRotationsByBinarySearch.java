/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying.array;

/**
 * Find the Rotation Count in Rotated Sorted array
 * @author cwenao
 * @version $Id CountRotationsByBinarySearch.java, v 0.1 2017-08-01 06:19 cwenao Exp $$
 */
public class CountRotationsByBinarySearch {


    private int countRotations(int[] array, int low, int high) {
        if (high < low) {
            return 0;
        }
        if (high == low) {
            return low;
        }
        int mid = (high - low) / 2 + low;

        //如果m+1为最小值，数组又是rotations and sorted
        //则需要循环个数为m+1
        if (mid < high && array[mid + 1] < array[mid]) {
            return mid + 1;
        }

        if (mid > low && array[mid] < array[mid - 1]) {
            return mid;
        }

        if (array[high] > array[mid]) {
            return countRotations(array, low, mid - 1);
        }

        return countRotations(array, mid + 1, high);
    }

    public static void main(String[] args) {
        int[] array = {15, 18, 2, 3, 6, 12};
        CountRotationsByBinarySearch countRotationsByBinarySearch = new CountRotationsByBinarySearch();
        System.out.println(countRotationsByBinarySearch.countRotations(array, 0, array.length - 1));

    }
}
