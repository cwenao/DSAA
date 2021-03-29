/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.second;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id IntervalIntersection.java, v1.0.0 2021-03-29 10:06 cwenao Exp $$
 */
public class IntervalIntersection {

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0, j = 0;
        List<int[]> result = new ArrayList<>();

        while (i < A.length && j < B.length) {
            int start = Math.max(A[i][0], B[j][0]);
            int end = Math.max(A[i][1], A[j][1]);

            if (start <= end) {
                result.add(new int[]{start, end});
            }
            if (A[i][1] < B[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
