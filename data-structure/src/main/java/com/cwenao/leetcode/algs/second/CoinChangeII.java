/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.second;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id CoinChangeII.java, v1.0.0 2021-01-26 05:50 cwenao Exp $$
 */
public class CoinChangeII {

    public int change(int amount, int[] coins) {
        return changeByDP(amount, coins);
    }

    private int changeByDP(int amount, int[] coins) {

        //dp[i][j]: coins[0..i]个银币和为j的组合个数
        //dp[i][j] = dp[i-1][j] + dp[i][j-nums[i-1]]

        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }

        return dp[n][amount];
    }
}

