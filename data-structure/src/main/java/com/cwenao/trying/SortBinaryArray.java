/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying;

/**
 * @author cwenao
 * @version $Id SortBinaryArray.java, v 0.1 2017-06-28 0:10 cwenao Exp $$
 */
public class SortBinaryArray {


    private static void sort(int[] sortArray) {
        int pivot = 1;
        int achok = 0;
        for (int i =0 ;i<sortArray.length;i++) {
            if (sortArray[i] < pivot) {
                int tmp = sortArray[i];
                sortArray[i] = sortArray[achok];
                sortArray[achok] = tmp;
                achok++;
            }
        }
    }

    public static void main(String[] args) {
        int[] sortArray = {0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1};
        sort(sortArray);
        for (int x : sortArray) {
            System.out.println(x);
        }

    }


}

