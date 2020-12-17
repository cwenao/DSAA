/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id CoinChangeII.java, v1.0.0 2020-12-18 06:51 cwenao Exp $$
 */
public class CoinChangeII {

    public int change(int amount, int[] coins) {
        return changeByDP(amount, coins);
    }

    private int changeByDP(int amount, int[] coins) {

        int[][] dp = new int[coins.length + 1][amount + 1];
        int n = coins.length;

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        //dp[i][j]: 0...i 个硬币的和为j的个数
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

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};
        CoinChangeII coinChangeII = new CoinChangeII();
        System.out.println(coinChangeII.change(amount,coins));
    }

}
