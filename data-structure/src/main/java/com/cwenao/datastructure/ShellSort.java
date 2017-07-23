/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure;

import java.awt.*;

/**
 * 希尔排序
 * @author cwenao
 * @version $Id ShellSort.java, v 0.1 2017-05-10 8:59 cwenao Exp $$
 */
public class ShellSort {

    /**
     * 假设h为有序数组长度
     * 则比较时只需将第 j 个元素与第j-h个元素对比
     * j = j-h
     * @param shellArray
     * @return
     */
    public static int[] shell(int[] shellArray) {
        int len = shellArray.length;
        int h = 1;

        while (h < len / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for(int i =h;i<len;i++) {
                for (int j = i; j >= h && shellArray[j] > shellArray[j - h]; j -= h) {
                    int temp = shellArray[j];
                    shellArray[j] = shellArray[j - h];
                    shellArray[j - h] = temp;
                }
            }
            h = h / 3;
        }
        return shellArray;
    }

    public static void main(String[] args) {

        int[] shellArray = new int[]{10, 8, 11, 2, 6, 99, 1, 100, 104, 55, 3, 4, 44, 108, 300, 33};
        shell(shellArray);
        int n = shellArray.length * 5;
        for (int x =0; x< shellArray.length; x++) {
           System.out.println(x);
        }
    }

}

