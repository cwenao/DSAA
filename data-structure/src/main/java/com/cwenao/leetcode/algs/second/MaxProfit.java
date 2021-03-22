/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.second;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id MaxProfit.java, v1.0.0 2021-03-22 20:13 cwenao Exp $$
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        return maxProfitByDP(prices);
    }

    private int maxProfitByDP(int[] prices) {

        //DP[i][0]: 第i天未持有股票获得的利润
        //DP[i][1]: 第i天持有股票获得的利润

        //dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i])
        //dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]) -> dp[i-1][0]=0,只能买卖一次，所以未持有时利润为0

        int n = prices.length;

        int[][] dp = new int[n+1][2];
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE; //第0天持有情况不存在

        for (int i = 1; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i-1]);
            dp[i][1] = Math.max(dp[i - 1][1], - prices[i-1]);
        }

        return dp[n][0];
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
//        int[] prices = {1,2};
        MaxProfit maxProfit = new MaxProfit();
        System.out.println(maxProfit.maxProfit(prices));
    }
}
