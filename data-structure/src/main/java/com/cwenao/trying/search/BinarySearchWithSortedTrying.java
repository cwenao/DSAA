/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying.search;

/**
 * @author cwenao
 * @version $Id BinarySearchWithSortedTrying.java, v 0.1 2017-10-17 13:36 cwenao Exp $$
 */
public class BinarySearchWithSortedTrying {

    public static int binarySearchIndex(int[] array, int target, int low, int high) {

        if (low > high) {
            return -1;
        }

        int mid = (high + low) / 2;

        if (target == array[mid]) {
            return mid;
        }

        if (target > array[mid]) {
            return binarySearchIndex(array, target, mid + 1, high);
        } else {
            return binarySearchIndex(array, target, low, mid - 1);
        }
    }

    public static void main(String[] args) {
        int[] targetArray = {1, 2, 4, 6, 8, 11, 34, 55, 66, 75, 78, 100, 1000, 10000};
        System.out.println(binarySearchIndex(targetArray,66,0,targetArray.length-1));
    }
}
