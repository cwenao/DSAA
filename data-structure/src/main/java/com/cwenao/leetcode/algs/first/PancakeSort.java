/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id PancakeSort.java, v1.0.0 2021-01-17 09:35 cwenao Exp $$
 */
public class PancakeSort {

    private List<Integer> results = new ArrayList<>();

    public List<Integer> pancakeSort(int[] arr) {
        sort(arr, arr.length);
        return results;
    }

    private void sort(int[] arr, int length) {
        if (length == 1) {
            return;
        }
        int max = 0;
        int maxIndex = 0;

        for (int i = 0; i < length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }

        //第一次翻转，将最大值置顶
        reverse(arr, 0, maxIndex);
        results.add(maxIndex + 1);

        //第二次翻转将最大值放n-1位置

        reverse(arr, 0, length - 1);
        results.add(length);

        sort(arr, length - 1);
    }

    private void reverse(int[] arr, int start, int end ) {
        while (start < end) {
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }

}
