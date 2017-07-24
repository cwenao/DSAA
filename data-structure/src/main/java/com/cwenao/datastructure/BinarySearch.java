/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure;

import com.cwenao.common.annotation.AuxiliarySpace;
import com.cwenao.common.annotation.TimeComplexity;

/**
 * 在二分查找的按照数组有序进行
 * @author cwenao
 * @version $Id BinarySearch.java, v 0.1 2017-07-18 13:12 cwenao Exp $$
 */
public class BinarySearch {

    @TimeComplexity("O(log n)")
    @AuxiliarySpace("O(1)")
    private static int recursionBinarySearch(int[] array, int targetNum, int low, int high) {

        if (array == null || array.length == 0) {
            return -1;
        }
        if (low >= high) {
            return -1;
        }

        int mid = (low + high) / 2;
        if (array[mid] == targetNum) {
            return mid;
        }
        if (targetNum > array[mid]) {
            return recursionBinarySearch(array, targetNum, mid + 1, high);
        } else {
            return recursionBinarySearch(array, targetNum, low, mid - 1);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 4, 5, 8, 11, 42, 66, 78, 90, 114, 256};
        int targetNum = 11;
        int low = 0;
        int high = array.length;

        int index = recursionBinarySearch(array, targetNum, low, high-1);
        System.out.println("The index for targetNum is : " + index);
    }

}

