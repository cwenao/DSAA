/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id TrapByRain.java, v1.0.0 2021-01-17 14:37 cwenao Exp $$
 */
public class TrapByRain {

    public int trap(int[] height) {

        if (height.length == 0) {
            return 0;
        }

        int lLen = 0;
        int rLen = height.length - 1;
        int result = 0;

        int lMax = height[0];
        int rMax = height[height.length - 1];

        while (lLen < rLen) {
            lMax = Math.max(lMax, height[lLen]);
            rMax = Math.max(rMax, height[rLen]);

            if (lMax < rMax) {
                result += lMax - height[lLen];
                lLen++;
            } else {
                result += rMax - height[rLen];
                rLen--;
            }
        }

        return result;
    }

}
