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
 * @version $Id RemoveCoveredIntervals.java, v1.0.0 2020-12-17 06:47 cwenao Exp $$
 */
public class RemoveCoveredIntervals {

    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b) ->{
            if (a[0] == b[0]) {
                return b[1] - b[0];
            }
            return a[0] - b[0];
        });

        //初始化区间
        int start = intervals[0][0];
        int end = intervals[0][1];
        //覆盖区间数量
        int num = 0;

        for (int i = 1; i < intervals.length; i++) {
            int[] tmp = intervals[i];
            if (start <= tmp[0] && end >= tmp[1]) {
                num++;
            }
            if (end >= tmp[0] && end <= tmp[1]) {
                end = tmp[1];
            }

            if (end < tmp[0]) {
                start = tmp[0];
                end = tmp[1];
            }
        }

        return intervals.length - num;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 4}, {3, 6}, {2, 8}};

        RemoveCoveredIntervals removeCoveredIntervals = new RemoveCoveredIntervals();
        System.out.println(removeCoveredIntervals.removeCoveredIntervals(intervals));

    }

}
