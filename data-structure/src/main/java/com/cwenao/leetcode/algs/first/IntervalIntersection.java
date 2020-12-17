/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id IntervalIntersection.java, v1.0.0 2020-12-17 11:26 cwenao Exp $$
 */
public class IntervalIntersection {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> result = new ArrayList<>();

        int i = 0, j = 0;

        while (i < A.length && j < B.length) {
            int start = Math.max(A[i][0], B[j][0]);
            int end = Math.min(A[i][1], B[j][1]);
            //重合区域
            if (start <= end) {
                result.add(new int[]{start,end});
            }
            if (A[i][1] < B[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int A[][] = {{0,2},{5,10},{13,23},{24,25}};
        int B[][] = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        IntervalIntersection intervalIntersection = new IntervalIntersection();
        int[][] result = intervalIntersection.intervalIntersection(A, B);
        System.out.println("end");
    }
}
