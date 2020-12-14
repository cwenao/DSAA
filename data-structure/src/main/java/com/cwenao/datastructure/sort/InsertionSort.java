/*
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure.sort;

/**
 * Insertion Sort
 * 插入排序：从顶部取元素，然后循环遍历与当前值比较
 * 如果符合条件则插入，其他元素依次后移
 * @author cwenao
 * @version $Id InsertionSort.java, v 0.1 2017-05-01 14:41 cwenao Exp $$
 */
public class InsertionSort {

    /**
     * 插入排序
     * 时间复杂度 n²
     * @param integerArray
     * @return
     */
    public static Integer[] insertionSortASC(Integer[] integerArray) {

        if (null == integerArray || integerArray.length < 1) {
            return null;
        }
        //取顶部元素开始，即1...j个元素都是已经排序
        //满足 循环不变式：初始化、保持、终止
        for (int j=1 ;j < integerArray.length;j++) {

            int key = integerArray[j];
            int i = j - 1;
            //将当前元素依次
            while (i > 0 && integerArray[i] > key) {
                integerArray[i + 1] = integerArray[i];
                i = i - 1;
            }

            integerArray[i+1] = key;

        }

        return integerArray;
    }

    public static Integer[] insertionSortDESC(Integer[] integerArray) {
        if (null == integerArray || integerArray.length < 1) {
            return null;
        }

        for(int j=1;j<integerArray.length;j++) {
            int key = integerArray[j];
            int i = j;

            while (i >0   && key > integerArray[i-1]) {
                integerArray[i] = integerArray[i-1];
                i = i - 1;
            }

            integerArray[i] = key;
        }
        return integerArray;
    }


    public static void main(String[] args) {
        Integer[] sorti = new Integer[]{1, 35, 2, 44, 100, 55};
        //Integer[] x = InsertionSort.insertionSortASC(sorti);
        Integer[] x = InsertionSort.insertionSortDESC(sorti);
        for (int ss : x) {
            System.out.println(ss);
        }

    }


}

