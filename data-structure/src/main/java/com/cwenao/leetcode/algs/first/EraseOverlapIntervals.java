/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

import java.util.Arrays;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id EraseOverlapIntervals.java, v1.0.0 2020-12-19 15:21 cwenao Exp $$
 */
public class EraseOverlapIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        return eraseOverlapIntervalsByGreedy(intervals);
    }

    private int eraseOverlapIntervalsByGreedy(int[][] intervals) {

        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        //计算做多不重叠的区域
        //按end升序排列
        Arrays.sort(intervals,(a,b)->{
            return a[1] - b[1];
        });

        int n = intervals.length;
        int end = intervals[0][1];
        int count = 1;
        for (int i = 0; i < n; i++) {
            if (end <= intervals[i][0]) {
                end = intervals[i][1];
                count++;
            }
        }
        return n - count;
    }

    public static void main(String[] args) {
        EraseOverlapIntervals eraseOverlapIntervals = new EraseOverlapIntervals();
//        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
//        int[][] intervals = {{1, 2}, {1, 2}, {1, 2}};
//        int[][] intervals = {{1, 2}, {2, 3}};
        int[][] intervals = {{1,100},{11,22},{1,11},{2,12}};
        System.out.println(eraseOverlapIntervals.eraseOverlapIntervals(intervals));

    }
}
