/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.second;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id FindTargetSumWaysByDP.java, v1.0.0 2021-03-30 06:41 cwenao Exp $$
 */
public class FindTargetSumWaysByDP {

    private int result;

    public int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 0) {
            return 0;
        }
        return findTargetSumWaysByBacktracking(nums, S);
    }

    private int findTargetSumWaysByBacktracking(int[] nums, int s) {

        backtracking(nums, 0, s);

        return result;
    }

    private void backtracking(int[] nums, int start, int target) {

        if (start == nums.length) {
            if (target == 0) {
                result++;
            }
            return;
        }

        target += nums[start];
        backtracking(nums, start + 1, target);
        target -= nums[start];

        target -= nums[start];
        backtracking(nums, start + 1, target);
        target = +nums[start];
    }
}
