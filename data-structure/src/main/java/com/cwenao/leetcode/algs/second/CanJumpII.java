/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.second;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id CanJumpII.java, v1.0.0 2021-04-16 14:41 cwenao Exp $$
 */
public class CanJumpII {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return jumpByGreedy(nums);
    }

    private int jumpByGreedy(int[] nums) {

        //当前nums[i]下次跳跃的选择项
        //选其最大项
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
