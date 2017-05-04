/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure;

import java.util.Arrays;

/**
 * 用分治法的思想进行分解
 * 然后针对最小解决值进行合并
 * 归并的默认两个合并的序列已经进行排序
 * 只需要依次比较两个序列中的大小即可
 * @author cwenao
 * @version $Id ConflationSort.java, v 0.1 2017-05-01 16:16 cwenao Exp $$
 */
public class ConflationSort {

    /**
     * 合并两个相邻的结果
     * @param sortArray
     * @param low
     * @param mid
     * @param high
     */
    public static void merger(int[] sortArray, int low, int mid, int high) {

        int[] tmp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int x = 0;

        while (i <= mid && j <= high) {
            if (sortArray[i] <= sortArray[j]) {
                tmp[x++] = sortArray[i++];
            } else {
                tmp[x++] = sortArray[j++];
            }
        }

        while (i <= mid) {
            tmp[x++] = sortArray[i++];
        }

        while (j <= high) {
            tmp[x++] = sortArray[j++];
        }

        for(int k =0 ;k <tmp.length;k++) {
            sortArray[low + k] = tmp[k];
        }
    }

    //The recursion call the function
    //n lgn

    /**
     * 分治法算法：
     * 归并排序：递归与合并
     * 分解、解决、合并
     * 时间复杂度为 n(lgn)
     * @param integers
     * @param low
     * @param high
     * @return
     */
    public static int[] ConflationSortASC(int[] integers, int low, int high) {

        if (null == integers || integers.length < 1) {
            return null;
        }

        int mid = (low + high) / 2;

        if (low < high) {
            ConflationSortASC(integers, low, mid);
            ConflationSortASC(integers, mid + 1, high);
            merger(integers, low, mid, high);
        }

        return integers;
    }



    public static void main(String[] args) {
        int[] sorti = new int[]{1, 35, 2, 44, 100, 55};

        int[] x = ConflationSortASC(sorti, 0, sorti.length - 1);
        System.out.println(Arrays.toString(x));

    }


}

