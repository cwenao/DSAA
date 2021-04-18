/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.second;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id CanJumpI.java, v1.0.0 2021-04-16 14:16 cwenao Exp $$
 */
public class CanJumpI {
    public boolean canJump(int[] nums) {

        if (nums == null || nums.length == 0) {
            return false;
        }

        return canJumpByGreedy(nums);
    }

    private boolean canJumpByGreedy(int[] nums) {
        //设置最大距离fast与当前位置+当前值相比，取较大者
        //比较范围：nums[0:len-1]
        int fast = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            fast = Math.max(fast, i + nums[i]);
            if (fast <= i) {
                return false;
            }
        }

        return fast >= nums.length - 1;
    }
}
