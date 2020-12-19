/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id CanJumpI.java, v1.0.0 2020-12-19 16:27 cwenao Exp $$
 */
public class CanJumpI {
    public boolean canJump(int[] nums) {
        return canJumpByGreedy(nums);
    }

    private boolean canJumpByGreedy(int[] nums) {

        if (nums == null || nums.length == 0) {
            return false;
        }

        int fast = 0;
        for (int i = 0; i < nums.length-1; i++) { //遍历范围为 nums[0:len-1)
            //求最远距离
            fast = Math.max(fast, i + nums[i]);
            //为0
            if (fast <= i) {
                return false;
            }
        }

        return fast >= nums.length - 1;
    }
}
