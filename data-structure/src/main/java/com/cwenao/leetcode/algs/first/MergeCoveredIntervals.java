/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id MergeCoveredIntervals.java, v1.0.0 2020-12-17 10:05 cwenao Exp $$
 */
public class MergeCoveredIntervals {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals,(a,b) ->{
            return a[0] - b[0];
        });

        List<int[]> re = new ArrayList<>();
        int end = Integer.MIN_VALUE;
        int len = -1;

        for (int i = 0; i < intervals.length; i++) {
            int[] current = intervals[i];

            if (current[0] <= end) {
                end = Math.max(current[1], end);
                int[] tmp = re.get(len);
                tmp[1] = end;
                re.set(len, tmp);
            } else {
                len++;
                re.add(current);
                end = current[1];
            }
        }
        return re.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        MergeCoveredIntervals mergeCoveredIntervals = new MergeCoveredIntervals();
        int [][] tmp = mergeCoveredIntervals.merge(intervals);

        System.out.println("end");

    }

}
