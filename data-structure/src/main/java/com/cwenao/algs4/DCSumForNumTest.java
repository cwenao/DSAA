/**
 * Company Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.algs4;

/**
 *
 * 用分治法求数组中数字之和
 * @author cwenao
 * @version $Id DCSumForNumTest.java, v1.0.0 2020-04-20 09:40 cwenao Exp $$
 */
public class DCSumForNumTest {

    private int dcSum(int[] source,int start,int end) {

        if (end == start || start>=end) {
            return source[end];
        }

        int mid = (start + end) / 2;

        int startIndex = dcSum(source, start, mid);
        int endIndex = dcSum(source, mid + 1, end);

        return startIndex + endIndex;

    }

    public static void main(String[] args) {

//        int[] test = new int[]{1,4,5,7,9,10,0,2};
        int[] test = new int[]{1};

        DCSumForNumTest dcSumForNumTest = new DCSumForNumTest();

        System.out.println(dcSumForNumTest.dcSum(test, 0, test.length-1));

    }
}
