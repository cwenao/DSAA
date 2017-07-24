/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying.array;

import com.cwenao.common.annotation.AuxiliarySpace;
import com.cwenao.common.annotation.TimeComplexity;
import com.cwenao.util.PrintArrayCommon;

/**
 * 求最大公因子，rotatearray
 * @author cwenao
 * @version $Id RotateArrayByGCD.java, v 0.1 2017-07-24 8:25 cwenao Exp $$
 */
public class RotateArrayByGCD {
    /**
     * 求GCD（最大共因子算法）
     * @param array
     * @param index
     */
    @TimeComplexity("O(n*index)")
    @AuxiliarySpace("O(1)")
    public void rotateArray(int[] array, int index) {
        int tmp;
        int j;
        int k;

        for(int i=0; i< gcd(index,array.length);i++) {
            tmp = array[i];
            j = i;

            while (true) {
                k = j + index;
                if (k >= array.length) {
                    k = k - array.length;
                }
                if (k == i) {
                    break;
                }
                array[i] = array[k];
                j = k;
            }
            array[j] = tmp;
        }
        PrintArrayCommon.printArray(array);
    }

    private int gcd(int index, int size) {
        if (size == 0) {
            return index;
        }
        return gcd(size, index % size);
    }

    public static void main(String[] args) {
        RotateArrayByGCD rotateArrayByGCD = new RotateArrayByGCD();

        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        rotateArrayByGCD.rotateArray(sortedArray, 3);
    }
}

