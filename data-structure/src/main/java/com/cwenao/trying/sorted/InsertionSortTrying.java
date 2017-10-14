/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying.sorted;

/** Get
 * Key 0 ~ i 为已经排序
 * 符合条件的依次往后推
 * @author cwenao
 * @version $Id InsertionSortTrying.java, v 0.1 2017-10-14 11:51 cwenao Exp $$
 */
public class InsertionSortTrying {

    private static void insertionSortAsc(int[] sortedArray) {

        for (int i = 1 ; i < sortedArray.length; i++) {
            int key = sortedArray[i];
            int j = i - 1;
            while (j >= 0 &&  sortedArray[j] > key) {
                sortedArray[j+1] = sortedArray[j];
                j = j - 1;
            }
            sortedArray[j+1] = key;
        }
    }

    private static void insertionSortDesc(int[] sortedArray) {

        for (int i = 1; i < sortedArray.length; i++) {
            int key = sortedArray[i];
            int j = i - 1;
            while (j >= 0 && sortedArray[j] < key) {
                sortedArray[j + 1] = sortedArray[j];
                j--;
            }
            sortedArray[j+1] = key;
        }

    }

    public static void main(String[] args) {
        int[] shellArray = new int[]{10, 8, 11, 2, 6, 99, 1, 100, 104, 55, 3, 4, 44, 108, 300, 33};
        insertionSortDesc(shellArray);
        for (int i : shellArray) {
            System.out.println(i);
        }
    }

}
