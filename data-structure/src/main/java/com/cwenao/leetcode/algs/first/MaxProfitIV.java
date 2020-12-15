/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id MaxProfitIV.java, v1.0.0 2020-12-15 12:39 cwenao Exp $$
 */
public class MaxProfitIV {

    public int maxProfit(int k, int[] prices) {

        return maxProfitByDPWithK(k, prices);

    }

    private int maxProfitByDPWithK(int k, int[] prices) {

        int n = prices.length;
        if (k > n / 2) {
            return maxProfitByDPWithInfiniteK(prices);
        }
        int maxK = k;
        n = n + 1; //base case dp[-1]时使用
        int[][][] dp = new int[n][maxK + 1][2];

        for (int i = 0; i < n; i++) {
            for (k = maxK; k >= 1; k--) {

                if (i == 0) {
                    dp[i][0][0] = dp[0][k][0] = 0;
                    dp[i][0][1] = dp[i][k][1] = Integer.MIN_VALUE;
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i - 1]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i - 1]);

            }
        }

        return dp[n - 1][maxK][0];
    }

    private int maxProfitByDPWithInfiniteK(int[] prices) {

        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            int tmp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, tmp - prices[i]);

        }
        return dp_i_0;
    }

    public static void main(String[] args) {
        int k = 2;
//        int[] prices = {2, 4, 1};
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};

        MaxProfitIV maxProfitIV = new MaxProfitIV();
        System.out.println(maxProfitIV.maxProfit(k,prices));
    }
}
