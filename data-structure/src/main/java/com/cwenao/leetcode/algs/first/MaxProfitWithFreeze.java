/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id MaxProfitWithFreeze.java, v1.0.0 2020-12-15 15:19 cwenao Exp $$
 */
public class MaxProfitWithFreeze {

    public int maxProfit(int[] prices) {
        return maxProfitByDP(prices);
    }

    private int maxProfitByDP(int[] prices) {

        //define： dp[i][K][0] / dp[i][K][1]
        //i：第N天
        //K：最大允许交易次数,这里K可以无限次交易
        //0,1: 未持有/持有

        //base case :
        //dp[i][0][0] = dp[-1][k][0] = 0
        //dp[i][0][1] = dp[-1][k][1] = Integer.MIN_VALUE;

        //状态转移方程
        //dp[i][k][0] = Math.max(dp[i-1][k][0],dp[i-1][k][1] + prices[i])
        //dp[i][k][1] = Math.max(dp[i-1][k][1],dp[i-2][k-1][0] - prices[i])
        //====> k 可以 +∞ ,则k不再约束状态方程。简化方程
        //dp[i][k][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i])
        //dp[i][k][1] = Math.max(dp[i-1][1],dp[i-2][0] - prices[i])

        int n = prices.length;
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        int dp_prei_0 = 0;

        for (int i = 0; i < n; i++) {
            int tmp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_prei_0 - prices[i]);
            dp_prei_0 = tmp;
        }

        return dp_i_0;
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        MaxProfitWithFreeze maxProfitWithFreeze = new MaxProfitWithFreeze();
        System.out.println(maxProfitWithFreeze.maxProfit(prices));

    }

}
