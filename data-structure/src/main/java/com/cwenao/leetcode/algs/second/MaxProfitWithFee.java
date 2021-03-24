/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.second;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id MaxProfitWithFee.java, v1.0.0 2021-03-23 00:07 cwenao Exp $$
 */
public class MaxProfitWithFee {
    public int maxProfit(int[] prices, int fee) {

        return maxProfitWithFeeByDP(prices, fee);
    }

    private int maxProfitWithFeeByDP(int[] prices, int fee) {

        //dp[i][h]: 第i天持有/未持有的利润
        //一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费
        //设置买入支付手续rob费
        //dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i])
        //dp[i][1] = Math,max(dp[i-1][1],dp[i-1][0]-prices[i]-fee)

        int n = prices.length;
        int[][] dp = new int[n + 1][2];

        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;

        for (int i = 1; i <=n ; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1] - fee);
        }

        return dp[n][0];
    }

    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        MaxProfitWithFee maxProfitWithFee = new MaxProfitWithFee();
        System.out.println(maxProfitWithFee.maxProfit(prices,fee));
    }

}
