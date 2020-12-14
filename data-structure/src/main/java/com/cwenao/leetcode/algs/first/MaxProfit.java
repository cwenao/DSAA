/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id MaxProfit.java, v1.0.0 2020-12-14 20:46 cwenao Exp $$
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {

        return maxProfitByDP(prices);
    }

    private int maxProfitByDP(int[] prices) {
        //define： dp[i][K][0] / dp[i][K][1]
        //i：第N天
        //K：最大允许交易次数
        //0,1: 未持有/持有

        //base case: -1表示未开始
        // dp[i][0][0] = dp[-1][K][0] = 0
        // dp[i][0][1] = dp[-1][K][1] = Integer.MIN_VALUE;

        //状态转移方程
        //dp[i][K][0] = Math.max(dp[i-1][K][0],dp[i-1][K][1] + prices[i])
        //dp[i][K][1] = Math.max(dp[i-1][K][1],dp[i-1][K-1][0] - prices[i])

        int n = prices.length;

        //未持有利润
        int dp_i_0 = 0;
        //初始化持有但未交易，不存在此种情况
        int dp_i_1 = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }

        return dp_i_0;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        MaxProfit maxProfit = new MaxProfit();
        System.out.println(maxProfit.maxProfit(prices));

    }
}
