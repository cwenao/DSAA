/**
 * Company
 * Copyright (C) 2014-2018 All Rights Reserved.
 */
package com.cwenao.trying.array;

/**
 * @author cwenao
 * @version $Id RearrangePositiveAndNegative.java, v 0.1 2018-01-09 07:19 cwenao Exp $$
 */
public class RearrangePositiveAndNegative {
    private static void rearrange(int[] array) {
        int n = array.length;
        int i = -1;

        for (int j=0;j<n;j++) {
            if (array[j] < 0) {
                i++;
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }

        int pos = i + 1;
        int neg = 0;

        while (pos < n && neg < pos && array[neg] < 0) {
            int tmp = array[neg];
            array[neg] = array[pos];
            array[pos] = tmp;
            pos++;
            neg += 2;
        }

    }

    public static void main(String[] args) {
        int[] array = {-1, 2 - 3, 4, 5, -8, 9, 10, -2, 11, 3};
        rearrange(array);

        for (int x : array) {
            System.out.println(x+" =====> ");
        }

    }
}
