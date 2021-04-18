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
 * @version $Id FindMinArrowShots.java, v1.0.0 2021-04-16 13:48 cwenao Exp $$
 */
public class FindMinArrowShots {

    public int findMinArrowShots(int[][] points) {
        return findMinArrowShotsByGreedy(points);
    }

    private int findMinArrowShotsByGreedy(int[][] points) {

        //需要射的箭的次数=最大不相加次数
        //数组需要按结束坐标升序排序

        Arrays.sort(points,(a,b)->{
            if (a[1] > b[1]) {
                return 1;
            } else if (a[1] < b[1] ) {
                return -1;
            } else {
                return 0;
            }
        });
        //求最大不相交区域
        int end = points[0][1];
        int counter = 1;
        for (int i = 0; i < points.length; i++) {
            if (end < points[i][0]) {
                end = points[i][1];
                counter++;
            }
        }
        return counter;
    }
}
