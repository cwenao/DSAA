/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.second;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id MaxProfitIV.java, v1.0.0 2021-03-22 21:41 cwenao Exp $$
 */
public class MaxProfitIV {

    public int maxProfitIV(int k, int[] prices) {
        return maxProfitIVByDP(k, prices);
    }

    private int maxProfitIVByDP(int maxK, int[] prices) {

        //dp[i][k][h]: 第i天完成k次交易后持有/未持有的利润
        //i：第N天
        //k：最大允许交易次数,这里K最大可以为2
        //h: 0,1 未持有/持有

        int n = prices.length;
        int[][][] dp = new int[n + 1][maxK + 1][2];

        dp[0][0][0] = 0;
        dp[0][0][1] = Integer.MIN_VALUE;

        for (int i = 0; i <= n; i++) {
            for (int k = maxK; k >= 1; k--) {
                if (i == 0) {
                    dp[i][k][0] =  0;
                    dp[i][k][1] = Integer.MIN_VALUE;
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i - 1]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i - 1]);
            }
        }
        return dp[n][maxK][0];
    }

    public static void main(String[] args) {
        int k = 2;
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};

        MaxProfitIV maxProfitIV = new MaxProfitIV();
        System.out.println(maxProfitIV.maxProfitIV(k, prices));

    }
}
