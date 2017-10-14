/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying.sorted;

/**
 * Get
 * 始终以第i个位置的元素与i+1...N进行比较，符合要求的元素m与第i个元素交换
 * @author cwenao
 * @version $Id SelectionSortTrying.java, v 0.1 2017-10-14 13:07 cwenao Exp $$
 */
public class SelectionSortTrying {

    private static void selectionSortAsc(int[] sortedArray) {
        for (int i = 0; i < sortedArray.length; i++) {
            for (int j = i + 1; j < sortedArray.length; j++) {
                if (sortedArray[i] < sortedArray[j]) {
                    int temp = sortedArray[i];
                    sortedArray[i] = sortedArray[j];
                    sortedArray[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] shellArray = new int[]{10, 8, 11, 2, 6, 99, 1, 100, 104, 55, 3, 4, 44, 108, 300, 33};
        selectionSortAsc(shellArray);
        for (int i : shellArray) {
            System.out.println(i);

        }
    }
}
