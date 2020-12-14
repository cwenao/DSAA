/*
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure.sort;

/**
 * bubble sort
 * @author cwenao
 * @version $Id BubbleSort.java, v 0.1 2017-07-02 13:27 cwenao Exp $$
 */
public class BubbleSort {

    private static void bubbleSortByDesc(int[] arrays) {
        int len = arrays.length;
        for (int i = 0; i < len; i++) {
            for(int x =0 ;x<len;x ++) {
                if ((x != len-1) && arrays[x] > arrays[x + 1]) {
                    int tmp = arrays[x];
                    arrays[x] = arrays[x + 1];
                    arrays[x + 1] = tmp;
                }
            }
        }

    }

    private static void bulleSortByAsc(int[] arrays) {
        int len = arrays.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0;j<len;j++) {
                if ((j != len - 1) && arrays[j] < arrays[j + 1] ) {
                    int tmp = arrays[j + 1];
                    arrays[j + 1] = arrays[j];
                    arrays[j] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arrays = {0, 100, 99, 105, 6, 1, 5, 4, 5, 22, 30, 45};
        //bubbleSortByDesc(arrays);
        bulleSortByAsc(arrays);
        for (int x : arrays) {
            System.out.println(x);
        }
    }

}

