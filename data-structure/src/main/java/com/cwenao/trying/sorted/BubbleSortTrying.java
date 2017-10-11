/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying.sorted;

/**
 * GET
 * @author cwenao
 * @version $Id BubbleSortTrying.java, v 0.1 2017-10-13 17:55 cwenao Exp $$
 */
public class BubbleSortTrying {

    private static void bubbleSortAsc(int[] sortArray) {
        for (int i = 0; i < sortArray.length; i++) {
            for (int v = 0; v < sortArray.length; v++) {
                if (v != sortArray.length - 1 && sortArray[v] < sortArray[v + 1]) {
                    int temp = sortArray[v];
                    sortArray[v] = sortArray[v+1];
                    sortArray[v + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] shellArray = new int[]{10, 8, 11, 2, 6, 99, 1, 100, 104, 55, 3, 4, 44, 108, 300, 33};
        bubbleSortAsc(shellArray);
        for (int i : shellArray) {
            System.out.println(i);
        }
    }

}