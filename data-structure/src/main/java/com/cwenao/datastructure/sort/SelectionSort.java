/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure.sort;

/**
 * 选择排序：
 * 元素i与i+1....N 个元素比较
 * 较小的元素放入到i位置
 * @author cwenao
 * @version $Id SelectionSort.java, v 0.1 2017-05-08 13:51 cwenao Exp $$
 */
public class SelectionSort {

    /**
     * 总共有N次交换以及(N-1)+(N-2)+...+2+1=N(N-1)/2 ～ N2/2 次比较
     * @param selectArray
     * @return
     */
    public static int[] selection(int[] selectArray) {

        if (null == selectArray || selectArray.length < 1) {
            return null;
        }
        int len = selectArray.length;

        for(int i=0; i<len;i++) {
            int temp = 0;
            for(int m = i+1; m < len;m++) {
                if (selectArray[i] > selectArray[m]) {
                    temp = selectArray[m];
                    selectArray[m] = selectArray[i];
                    selectArray[i] = temp;
                }
            }
        }
        return selectArray;
    }

    public static void main(String[] args) {
        int[] select = new int[]{5, 1, 2, 4, 0};
        int[] arr = selection(select);
        for (int x : arr) {
            System.out.println(x);
        }
    }
}

