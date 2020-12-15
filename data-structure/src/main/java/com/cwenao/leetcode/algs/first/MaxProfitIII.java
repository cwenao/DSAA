/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id MaxProfitIII.java, v1.0.0 2020-12-15 06:57 cwenao Exp $$
 */
public class MaxProfitIII {

    public int maxProfit(int[] prices) {
        return maxProfitByDP(prices);
    }

    private int maxProfitByDP(int[] prices) {

        //define： dp[i][K][0] / dp[i][K][1]
        //i：第N天
        //K：最大允许交易次数,这里K最大可以为2
        //0,1: 未持有/持有

        //base case: -1表示未开始
        // dp[i][0][0] = dp[-1][K][0] = 0
        // dp[i][0][1] = dp[-1][K][1] = Integer.MIN_VALUE;
        //======>dp[0][0][0] 表示未开始
        //=====> dp[-1][K][0] --------> dp[0][K][0]
        //=====> dp[-1][K][1] --------> dp[0][K][1]

        //状态转移方程
        //dp[i][K][0] = Math.max(dp[i-1][K][0],dp[i-1][K][1] + price[i])
        //dp[i][K][1] = Math.max(dp[i-1][K][1],dp[i-1][K-1][0]  - price[i])
        //=========> 需要遍历K的状态

        int n = prices.length + 1;
        int maxK = 2;

        int dp[][][] = new int[n][maxK + 1][2];

        for (int i = 0; i < n; i++) {
            for (int k = maxK; k >= 1; k--) {
                if (i == 0) {
                    dp[i][0][0] = dp[i][k][0] = 0;
                    dp[i][0][1] = dp[i][k][1] = Integer.MIN_VALUE;
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i-1]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i-1]);
            }
        }
        return dp[n - 1][maxK][0];
    }

    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
//        int[] prices = {1,2,3,4,5};
        MaxProfitIII maxProfitIII = new MaxProfitIII();
        System.out.println(maxProfitIII.maxProfit(prices));
    }
}
