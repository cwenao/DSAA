/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying.array;

import com.cwenao.common.annotation.TimeComplexity;
import com.cwenao.util.PrintArrayCommon;

/**
 * 需要反转的以及剩余部分各自首尾交换，使得数组反转，
 * 再通过交换
 * @author cwenao
 * @version $Id RotateArrayByReversal.java, v 0.1 2017-07-24 8:34 cwenao Exp $$
 */
public class RotateArrayByReversal {

    private void rotateArray(int[] array, int d) {
        int len = array.length;
        reversalArray(array, 0, d - 1);
        reversalArray(array, d, len - 1);
        reversalArray(array, 0, len - 1);

        PrintArrayCommon.printArray(array);
    }

    @TimeComplexity("O(n)")
    private void reversalArray(int[] array, int start, int end) {
        int tmp;
        while (start < end) {
            tmp = array[start];
            array[start] = array[end];
            array[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        RotateArrayByReversal rotateArrayByReversal = new RotateArrayByReversal();

        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        rotateArrayByReversal.rotateArray(sortedArray, 3);
    }

}

