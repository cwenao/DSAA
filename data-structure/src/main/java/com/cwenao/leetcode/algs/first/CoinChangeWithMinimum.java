/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id CoinChangeWithMininum.java, v1.0.0 2020-12-11 08:13 cwenao Exp $$
 */
public class CoinChangeWithMinimum {

    public int coinChange(int[] coins, int amount) {

        if (amount < 0) {
            return -1;
        }

        Map<Integer, Integer> dpMap = new HashMap<>();
//        return coinsCountByTopDown(coins, amount,dpMap);
        return coinsCountByBottomUp(coins, amount, dpMap);
    }

    private int coinsCountByBottomUp(int[] coins, int amount, Map<Integer, Integer> dpMap) {

        dpMap.put(0, 0);

        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                int min = Integer.MAX_VALUE;
                if (dpMap.containsKey(i)) {
                    min = dpMap.get(i);
                }
                dpMap.put(i, Math.min(min,
                        dpMap.containsKey(i - coin) && dpMap.get(i - coin) != Integer.MAX_VALUE ? (
                                dpMap.get(i - coin) + 1) : Integer.MAX_VALUE));
            }
        }

        return !dpMap.containsKey(amount) || dpMap.get(amount) == Integer.MAX_VALUE ? -1 : dpMap.get(amount);
    }

    private int coinsCountByTopDown(int[] coins, int amount, Map<Integer, Integer> dpMap) {

        //base case
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        //中间状态
        if (dpMap.containsKey(amount)) {
            return dpMap.get(amount);
        }

        int min = Integer.MAX_VALUE;

        //状态转移
        for (int coin : coins) {
            //确定状态-求最值
            int result = coinsCountByTopDown(coins, amount - coin, dpMap);
            if (result >= 0 && result < min) {
                min = 1 + result;
            }
        }
        dpMap.put(amount, min);

        return min == Integer.MAX_VALUE ? -1 : min;
    }


    public static void main(String[] args) {
        CoinChangeWithMinimum coinChangeWithMinimum = new CoinChangeWithMinimum();
        int[] coins = new int[]{186,419,83,408};

        System.out.println(coinChangeWithMinimum.coinChange(coins, 6249));
    }
}
