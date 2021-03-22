/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.second;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id MaxProfitIII.java, v1.0.0 2021-03-22 21:14 cwenao Exp $$
 */
public class MaxProfitIII {

    public int maxProfitIII(int[] prices) {
        return maxProfitIIIByDP(prices);
    }

    private int maxProfitIIIByDP(int[] prices) {

        //dp[i][k][h]: 第i天完成k次交易后持有/未持有的利润
        //i：第N天
        //k：最大允许交易次数,这里K最大可以为2
        //h: 0,1 未持有/持有

        //dp[i][k][0] = Math.max(dp[i-1][k][0],dp[i-1][k][1]+prices[i])
        //dp[i][k][1] = Math.max(dp[i-1][k][1],dp[i-1][k-1][0]+prices[i])

        int n = prices.length;
        int[][][] dp = new int[n + 1][3][2];

        for (int i = 0; i <= n; i++) {
            for (int k = 2; k >= 1; k--) {
                if (i == 0) {
                    dp[i][0][0] = dp[i][k][0] = 0;
                    dp[i][0][1] = dp[i][k][1] = Integer.MIN_VALUE;
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i - 1]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i - 1]);
            }
        }
        return dp[n][2][0];
    }

    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        MaxProfitIII maxProfitIII = new MaxProfitIII();
        System.out.println(maxProfitIII.maxProfitIII(prices));
    }

}
