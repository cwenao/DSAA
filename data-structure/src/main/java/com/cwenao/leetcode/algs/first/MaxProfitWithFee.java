/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id MaxProfitWithFee.java, v1.0.0 2020-12-15 16:40 cwenao Exp $$
 */
public class MaxProfitWithFee {

    public int maxProfit(int[] prices, int fee) {

        return maxProfitByDP(prices, fee);
    }

    private int maxProfitByDP(int[] prices, int fee) {

        int n = prices.length;
        //base case
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            //上一次卖出所获取利润
            int tmp = dp_i_0;
            //这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, tmp - prices[i] - fee);
        }

        return dp_i_0;
    }

    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        MaxProfitWithFee maxProfitWithFee = new MaxProfitWithFee();
        System.out.println(maxProfitWithFee.maxProfit(prices,fee));

    }

}
