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
 * @version $Id CanPartition.java, v1.0.0 2021-03-29 21:24 cwenao Exp $$
 */
public class CanPartition {

    public boolean canPartition(int[] nums) {
        return canPartitionByDP(nums);
    }

    private boolean canPartitionByDP(int[] nums) {

        //转化背包问题
        //dp[n][j]: nums[0..n]个元素，容量j时的状态，true则表示刚好装满
        //dp[n][j] = dp[n-1][j-nums[n-1]] | dp[n-1][j]

        //求两个子集和相等，则子集的和为sum(nums[0..n])/2
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }

        int n = nums.length;
        sum = sum / 2;
        boolean[][] dp = new boolean[sum + 1][];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - nums[i - 1] < 0) {
                    //当前容量不够
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //容量够
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] | dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
    }
//
}
