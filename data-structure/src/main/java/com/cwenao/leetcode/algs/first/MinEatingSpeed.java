/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id MinEatingSpeed.java, v1.0.0 2021-01-06 16:21 cwenao Exp $$
 */
public class MinEatingSpeed {

    public int minEatingSpeed(int[] piles, int H) {
        int low = 1, high = 1000000;

        while (low < high) {
            int mid = (low + high) / 2;
            if (!possible(piles, H, mid)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private boolean possible(int[] piles, int h, int k) {

        int time = 0;

        for (int pile : piles) {
            //香蕉为整数 存在吃半根的情况
            time += (pile - 1) / k + 1;
        }

        return time <= h;
    }

}
