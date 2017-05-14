/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure;

/**
 * 快速排序
 * 选择一个元素对数组进行切分
 * 切分后进行比较交换
 * @author cwenao
 * @version $Id QuickSort.java, v 0.1 2017-05-14 9:31 cwenao Exp $$
 */
public class QuickSort {

    /**
     * 切分
     * @param partitionArray
     * @param low
     * @param high
     * @return
     */
    private static int partition(int[] partitionArray, int low, int high) {
        int i = low;
        int j = high + 1;

        int par = partitionArray[low];

        while (true) {

            while (partitionArray[++i] > par) {
                if (i == high) {
                    break;
                }
            }

            while (par > partitionArray[--j]) {
                if (i == low) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }

            int temp = partitionArray[i];
            partitionArray[i] = partitionArray[j];
            partitionArray[j] = temp;

        }

        int temp = partitionArray[low];
        partitionArray[low] = partitionArray[j];
        partitionArray[j] = temp;

        return j;
    }

    private static void quickSort(int[] quickArray, int low, int high) {
        if (high <= low) {
            return;
        }

        int j = partition(quickArray, low, high);
        quickSort(quickArray, low, j - 1);
        quickSort(quickArray, j + 1, high);
    }

    public static void main(String[] args) {
        int[] shellArray = new int[]{10, 8, 11, 2, 6, 99, 1, 100, 104, 55, 3, 4, 44, 108, 300, 33};
        quickSort(shellArray, 0, shellArray.length - 1);

        for (int x : shellArray) {
            System.out.println(x);
        }

    }

}

