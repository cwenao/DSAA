/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying.array;

import java.util.Arrays;

/**
 * @author cwenao
 * @version $Id FindPair.java, v 0.1 2017-06-22 23:46 cwenao Exp $$
 */
public class FindPair {
    public static void findPairBySort(int sum, int[] array) {
        Arrays.sort(array);

        int low =0;
        int high = array.length - 1;

        while (low < high) {
            if ((array[low] + array[high]) == sum) {
                System.out.println(" this is the pair: " +array[low] + " and " +array[high]);
            }

            if ((array[low] + array[high]) < sum) {
                low++;
            } else {
                high --;
            }
        }

    }

    public static void main(String[] args) {
        int sum = 50;
        int[] array = {10,60,100,30,25,35,15,90,45,1,4,20};

        findPairBySort(sum, array);
    }
}

