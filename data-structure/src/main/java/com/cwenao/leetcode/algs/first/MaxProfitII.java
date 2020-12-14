/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id MaxProfitII.java, v1.0.0 2020-12-14 22:01 cwenao Exp $$
 */
public class MaxProfitII {

    public int maxProfit(int[] prices) {
        return maxProfitIIByDP(prices);
    }

    private int maxProfitIIByDP(int[] prices) {

        //define： dp[i][K][0] / dp[i][K][1]
        //i：第N天
        //K：最大允许交易次数,这里K可以为无限次
        //0,1: 未持有/持有

        //base case: -1表示未开始
        // dp[i][0][0] = dp[-1][K][0] = 0
        // dp[i][0][1] = dp[-1][K][1] = Integer.MIN_VALUE;

        //状态转移方程
        //dp[i][K][0] = Math.max(dp[i-1][K][0],dp[i-1][K][1] + price[i])
        //dp[i][K][1] = Math.max(dp[i-1][K][1],dp[i-1][K-1][0]  - price[i])
        // =====> K不影响交易
        //dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + price[i])
        //dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - price[i])

        int n = prices.length;

        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int tmp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, tmp - prices[i]);
        }

        return dp_i_0;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        MaxProfitII maxProfitII = new MaxProfitII();
        System.out.println(maxProfitII.maxProfit(prices));
    }
}
