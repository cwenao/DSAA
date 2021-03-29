/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id MergeCoveredIntervals.java, v1.0.0 2021-03-29 09:51 cwenao Exp $$
 */
public class MergeCoveredIntervals {

    public int[][] merge(int[][] intervals) {

        //排序
        Arrays.sort(intervals,(a,b)->{
            return a[0] - b[0];
        });
        return mergeIntervals(intervals);

    }

    private int[][] mergeIntervals(int[][] intervals) {

        List<int[]> result = new ArrayList<>();
        int end = Integer.MIN_VALUE;
        int len = -1;

        for (int i = 0; i < intervals.length; i++) {
            int[] current = intervals[i];
            if (current[0] <= end) {
                int[] tmp = result.get(len);
                end = Math.max(current[1], end);
                tmp[1] = end;
                result.set(len, tmp);
            } else {
                len++;
                result.add(current);
                end = current[1];
            }
        }
        return result.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        com.cwenao.leetcode.algs.first.MergeCoveredIntervals mergeCoveredIntervals = new com.cwenao.leetcode.algs.first.MergeCoveredIntervals();
        int [][] tmp = mergeCoveredIntervals.merge(intervals);

        System.out.println("end");

    }
}
