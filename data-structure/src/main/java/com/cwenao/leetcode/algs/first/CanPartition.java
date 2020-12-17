/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

import java.util.Arrays;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id CanPartition.java, v1.0.0 2020-12-17 21:16 cwenao Exp $$
 */
public class CanPartition {
    public boolean canPartition(int[] nums) {
        return canPartitionByDP(nums);
    }

    private boolean canPartitionByDP(int[] nums) {

        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int n = nums.length;
        //两个子集和相等则，每个子集的和为sum/2
        sum = sum / 2;

        //DP状态转移方程
        //dp[n][j]: 0...n个物品，当前背包容量为j时的状态，为true则表示刚好装满背包
        //dp[n-1][j-nums[n-1]]: n-1个物品体积为j-num[n-1]
        //dp[n][j] 状态由以下两个状态决定：
        //1.装入nums[n] = j（dp[n-1][j-nums[n-1]] )
        //2.不装入nums[n] = j (dp[n-1][j])
        //dp[n][j] = dp[n-1][j-nums[n-1]] | dp[n-1][j]


        boolean[][] dp = new boolean[n + 1][sum + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - nums[i - 1] < 0) {
                    //容量不够
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //容量够
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 12, 5};
        CanPartition canPartition = new CanPartition();
        System.out.println(canPartition.canPartition(nums));
    }
}
