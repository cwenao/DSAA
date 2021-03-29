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
 * @version $Id RemoveCoveredIntervals.java, v1.0.0 2021-03-25 09:23 cwenao Exp $$
 */
public class RemoveCoveredIntervals {

    public int removeCoveredIntervals(int[][] intervals) {

        Arrays.sort(intervals,(a,b) ->{
            //先按第一个数排序，第一个相等再按第二个数排序
            if (a[0] == b[0]) {
                return b[1] - b[0];
            }
            return a[0] - b[0];
        });

        //初始化
        int start = intervals[0][0];
        int end = intervals[0][1];
        //覆盖区间数量
        int num = 0;

        for (int i = 0; i < intervals.length; i++) {
            int[] tmp = intervals[i];

            //全覆盖
            if (start <= tmp[0] && end >= tmp[1]) {
                num++;
            }

            //合并区间
            if (end >= tmp[0] && end <= tmp[1]) {
                end = tmp[1];
            }

            //非重叠区间，更新区间大小
            if (end < tmp[0]) {
                start = tmp[0];
                end = tmp[1];
            }
        }

        return intervals.length - num;
    }

    public static void main(String[] args) {
//        System.out.println(1l << 32);
        System.out.println(4294967210l >>> 5); //134217725
//        System.out.println(4294967210l/32);
        System.out.println(-2l >> 32);
    }

}
