/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.second;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id MaxProfitWithFreeze.java, v1.0.0 2021-03-22 23:46 cwenao Exp $$
 */
public class MaxProfitWithFreeze {

    public int maxProfit(int[] prices) {
        return maxProfitWithFreezeByDP(prices);
    }

    private int maxProfitWithFreezeByDP(int[] prices) {

        //dp[i][h]: 第i天持有/未持有获得的利润
        //i：第N天
        //0,1: 未持有/持有
        //卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)
        //dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+price[i])
        //dp[i][1] = Math.max(dp[i-1][1],dp[i-2][0]-price[i])

        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1], ((i - 2) < 0 ? 0 : dp[i - 2][0]) - prices[i - 1]);
        }

        return dp[n][0];
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};

        MaxProfitWithFreeze maxProfitWithFreeze = new MaxProfitWithFreeze();
        System.out.println(maxProfitWithFreeze.maxProfit(prices));

    }
}
