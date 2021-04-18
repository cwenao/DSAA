/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.second;

import java.util.Arrays;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id EraseOverlapIntervals.java, v1.0.0 2021-04-16 11:26 cwenao Exp $$
 */
public class EraseOverlapIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        return eraseOverlapIntervalsByGreedy(intervals);
    }

    private int eraseOverlapIntervalsByGreedy(int[][] intervals) {

        //1、对数组进行排序
        //2、当前所在区间与数组中的开始区间比对
        Arrays.sort(intervals,(a,b)->{
            return a[1] - b[1];
        });

        int end = intervals[0][1];
        int counter = 1;

        for (int i = 1; i < intervals.length; i++) {
            //当end小于后面一个起始区间则统计为有效区间
            if (end <= intervals[i][0]) {
                end = intervals[i][1];
                counter++;
            }
        }
        return intervals.length - counter;
    }

    public static void main(String[] args) {
        EraseOverlapIntervals eraseOverlapIntervals = new EraseOverlapIntervals();
        int[][] intervals = {{1,100},{11,22},{1,11},{2,12}};
        System.out.println(eraseOverlapIntervals.eraseOverlapIntervals(intervals));

    }

}
