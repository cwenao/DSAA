/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.second;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id MaxProfitII.java, v1.0.0 2021-03-22 20:34 cwenao Exp $$
 */
public class MaxProfitII {

    public int maxProfit(int[] prices) {
        return maxProfitIIByDP(prices);
    }

    private int maxProfitIIByDP(int[] prices) {

        //dp[i][x]: [0..i]天持有或者未持有获取的利润
        //dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]) ->i-1天未持有利润与i-1天持有第i天卖出获取利润比
        //dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]) ->i-1天持有与i天未持有且买入利润
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;

        for (int i = 1; i <=n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i-1]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i-1]);
        }

        return dp[n][0];
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
//        int[] prices = {1,2};
        MaxProfitII maxProfitII = new MaxProfitII();
        System.out.println(maxProfitII.maxProfit(prices));

    }

}
