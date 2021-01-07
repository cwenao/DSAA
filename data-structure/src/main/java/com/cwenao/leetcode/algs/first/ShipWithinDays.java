/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id ShipWithinDays.java, v1.0.0 2021-01-06 17:19 cwenao Exp $$
 */
public class ShipWithinDays {
    public int shipWithinDays(int[] weights, int D) {

        int low = 1, high = Integer.MAX_VALUE;

        while (low < high) {
            int mid = (low + high) / 2;
            if (canShip(weights, D, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean canShip(int[] weights, int d, int loadCapacity) {
        //当前可用载重量
        int current = loadCapacity;

        for (int weight : weights) {
            //重量 > 载重量 则返回false
            if (weight > loadCapacity) {
                return false;
            }
            //当前可用载重量 < 货物重量
            if (current < weight) {
                //重置当前载重量
                current = loadCapacity;
                //进行天数计数
                d--;
            }
            //更新当前可用载重量
            current -= weight;
        }
        //d>0则表示能完成
        return d > 0;
    }
}
