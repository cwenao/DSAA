/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying.array;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author cwenao
 * @version $Id FindPairOtherWay.java, v 0.1 2017-07-26 8:30 cwenao Exp $$
 */
public class FindPairOtherWay {

    private static final Logger LOG = LoggerFactory.getLogger(FindPairOtherWay.class);

    private static void findPair(int[] array, int x) {
        int i;
        int len = array.length;
        for (i = 0; i < len - 1; i++) {
            if (array[i] > array[i + 1]) {
                break;
            }
        }

        int low = (i + 1) % len;
        int high = i;

        while (low != high) {
            if (array[low] + array[high] == x) {
                LOG.info("The x is {}, and the low element is {} , hig helement is {}",x,low,high);
                break;
            }

            if (array[low] + array[high] < x) {
                low = (low + 1) % len;
            } else {
                high = (high + len - 1) % len;
            }
        }
    }

    public static void main(String[] args) {
        // The array is must sorted and rotated
        int[] arrays = {0, 1, 3, 5, 10, 25, 4,6};
        findPair(arrays, 9);
    }

}

