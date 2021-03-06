/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying.array;

import com.cwenao.common.annotation.AuxiliarySpace;
import com.cwenao.common.annotation.TimeComplexity;

/**
 * @author cwenao
 * @version $Id OperationArray.java, v 0.1 2017-07-11 8:24 cwenao Exp $$
 */
public class OperationArray<E> {

    public int searchOnUnSortArray(E[] array, int len, E key) {
        for (int i =0;i<len;i++) {
            if (array[i] == key) {
                return  i;
            }
        }
        return -1;
    }


    public int insertOnUnSortArray(E[] array, int len, int index,E key) {
        if (index > len - 1) {
            return -1;
        }

        array[index] = key;

        return index + 1;
    }

    public void deleteOnUnSortArray(E[] array, int index,int len) {
        for (int i = index; i < len - 1; i++) {
            array[i] = array[i + 1];
        }
    }

    public int serachOnSortArray(int[] array, int low, int high, int key) {
        if (high < low) {
            return -1;
        }

        int mid = (low + high) / 2;
        if (array[mid] == key) {
            return mid;
        }
        if (array[mid] < key) {
            return serachOnSortArray(array, mid + 1, high, key);
        } else {
            return serachOnSortArray(array, low, mid - 1, key);
        }
    }




    public static void main(String[] args) {
        OperationArray<Integer> operationArray = new OperationArray<>();
        Integer[] array = {1, 2, 3, 5, 4, 6, 7, 8};
        int len = array.length;

        System.out.println(operationArray.searchOnUnSortArray(array, len, 3));

        operationArray.insertOnUnSortArray(array, len, 4, 100);

        System.out.println(operationArray.searchOnUnSortArray(array, len, 100));

        operationArray.deleteOnUnSortArray(array, 4, len);

        System.out.println(operationArray.searchOnUnSortArray(array, len, 100));
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int sortedLen = sortedArray.length;
        int low = 0;
        int high = sortedLen - 1;
        System.out.println(operationArray.serachOnSortArray(sortedArray, low, high, 3));

    }

}

