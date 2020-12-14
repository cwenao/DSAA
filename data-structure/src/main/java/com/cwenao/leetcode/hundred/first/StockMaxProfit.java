/**
 * Company Copyright (C) 2014-2019 All Rights Reserved.
 */
package com.cwenao.leetcode.hundred.first;

/**
 *
 * #122. 买卖股票的最佳时机 II
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 *
 * 解题思路：
 * 1. 不能进行多笔交易，
 *    A最佳买入点为相对于后一天的低点；
 *    B然后在后一天卖出，卖出后继续判断A
 * 2. 获取所有低点到高点差值
 *
 * @author cwenao
 * @version $Id StockMaxProfit.java, v1.0.0 2019-09-25 15:50 cwenao Exp $$
 */
public class StockMaxProfit {

    private int maxProfit(int[] prices) {

        int total = 0;

        if (prices == null || prices.length == 0) {
            return total;
        }

        for (int i = 1; i < prices.length; i++) {
            int tmp = prices[i] - prices[i-1];
            if (tmp > 0) {
                total += tmp;
            }
        }

        return total;

    }

    public static void main(String[] args) {

        StockMaxProfit stockMaxProfit = new StockMaxProfit();

//        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
//        int[] prices = new int[]{1,2,3,4,5};
        int[] prices = new int[]{7,6,4,3,1};
        System.out.println(stockMaxProfit.maxProfit(prices));
    }

}
