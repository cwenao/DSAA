/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

import java.util.Arrays;
import java.util.Comparator;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id FindMinArrowShots.java, v1.0.0 2020-12-19 15:39 cwenao Exp $$
 */
public class FindMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        return findMinArrowShotsByGreedy(points);
    }

    private int findMinArrowShotsByGreedy(int[][] points) {

        if (points == null || points.length == 0) {
            return 0;
        }

        //按结束坐标升序排列
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });


        int count = 1;
        int end =  points[0][1];

        //求最大不相互相交区域
        for (int i = 0; i < points.length; i++) {
            if (end < points[i][0]) {
                end = points[i][1];
                ++count;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        FindMinArrowShots findMinArrowShots = new FindMinArrowShots();
        System.out.println(findMinArrowShots.findMinArrowShots(points));
    }
}
