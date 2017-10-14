/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying.sorted;

/**
 * GET the quick sort
 * @author cwenao
 * @version $Id QuickSortTrying.java, v 0.1 2017-10-13 15:25 cwenao Exp $$
 */
public class QuickSortTrying {

    private static void quickSort(int[] positionArray, int low, int high) {

        if (low > high) {
            return;
        }
        int i = low;
        int j = high;

        int par = positionArray[low];

        while (true) {
            while (positionArray[j] >= par && i < j) {
                j--;
            }
            while (positionArray[i] <= par && i < j) {
                i++;
            }
            if (i >= j) {
                break;
            }
            int temp = positionArray[i];
            positionArray[i] = positionArray[j];
            positionArray[j] = temp;
        }
        positionArray[low] = positionArray[j];
        positionArray[j] = par;

        quickSort(positionArray, low, j - 1);
        quickSort(positionArray, j + 1, high);

    }

    public static void main(String[] args) {
        int[] shellArray = new int[]{10, 8, 11, 2, 6, 99, 1, 100, 104, 55, 3, 4, 44, 108, 300, 33};
        quickSort(shellArray, 0, shellArray.length - 1);

        for (int x : shellArray) {
            System.out.println(x);
        }

    }

}
