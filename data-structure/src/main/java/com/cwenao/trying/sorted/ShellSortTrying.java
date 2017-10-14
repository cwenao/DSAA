/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying.sorted;

/**
 * 1. 确定一个增量
 * 2. 按增量分组进行插入排序
 * 3. 减少增量
 * 4. 重复2.3
 * @author cwenao
 * @version $Id ShellSortTrying.java, v 0.1 2017-10-14 16:01 cwenao Exp $$
 */
public class ShellSortTrying {

    private static void shellSort(int[] sortedArray) {
        int len = sortedArray.length;
        int h = 1;
        while (h < len / 3) {
            h = h * 3 + 1;
        }

        while (h >= 1) {
            for (int i = h;i<len;i++) {
                for (int j=i; j>=h && sortedArray[j]>sortedArray[j-h];j-=h) {
                    int temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j - h];
                    sortedArray[j - h] = temp;
                }
            }
            h = h / 3;
        }
    }

    public static void main(String[] args) {
        int[] shellArray = new int[]{10, 8, 11, 2, 6, 99, 1, 100, 104, 55, 3, 4, 44, 108, 300, 33};
        shellSort(shellArray);
        for (int i : shellArray) {
            System.out.println(i);
        }
    }
}
