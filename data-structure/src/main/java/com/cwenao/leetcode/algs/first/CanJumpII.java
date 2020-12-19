/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id CanJumpII.java, v1.0.0 2020-12-19 16:37 cwenao Exp $$
 */
public class CanJumpII {

    public int jump(int[] nums) {
        return jumpByGreedy(nums);
    }

    private int jumpByGreedy(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int farthest = 0;
        int count = 0;
        int currentMaxDistanceStepEnd = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (currentMaxDistanceStepEnd == i) {
                count++;
                currentMaxDistanceStepEnd = farthest;
            }
        }

        return count;
    }

}
