/*
 * Company Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.algs4;

import java.util.Arrays;

/**
 *
 * TODO : Statement the class description
 * @author cwenao
 * @version $Id QuickSortedTest.java, v1.0.0 2020-04-21 07:19 cwenao Exp $$
 */
public class QuickSortedTest {

    private void quickSorted(int[] source, int low, int high) {

        if (low > high) {
            return;
        }

        int i = low;
        int j = high;

        int target = source[low];

        while (true) {
            while (source[j] >= target && j>i) {
                j--;
            }

            while (source[i] <= target && j>i) {
                i++;
            }

            if (i >= j) {
                break;
            }

            int tmp = source[j];
            source[j] = source[i];
            source[i] = tmp;
        }

        source[low] = source[j];
        source[j] = target;

        quickSorted(source, low, j - 1);
        quickSorted(source, j + 1, high);

    }

    public static void main(String[] args) {
        QuickSortedTest quickSortedTest = new QuickSortedTest();
        int[] shellArray = new int[]{10, 8, 11, 2, 6, 99, 1, 100, 104, 55, 3, 4, 44, 108, 300, 33};

        quickSortedTest.quickSorted(shellArray,0,shellArray.length-1);

        Arrays.stream(shellArray).forEach(System.out::println);

    }

}
