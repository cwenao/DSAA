/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.second;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id CoinChangeWithMinimum.java, v1.0.0 2021-01-25 06:01 cwenao Exp $$
 */
public class CoinChangeWithMinimum {

    private Map<Integer, Integer> dpMap = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }

        return coinsCountByBottomUp(coins, amount);

    }

    private int coinsCountByBottomUp(int[] coins, int amount) {

        dpMap.put(0, 0);
        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                int minimum = Integer.MAX_VALUE;
                if (dpMap.containsKey(i)) {
                    minimum = dpMap.get(i);
                }
                int currentAmount = i - coin;
                dpMap.put(i, Math.min(minimum, (dpMap.containsKey(currentAmount)
                        && dpMap.get(currentAmount) != Integer.MAX_VALUE) ?
                        (dpMap.get(currentAmount) + 1) : Integer.MAX_VALUE));
            }

        }
        return !dpMap.containsKey(amount) || dpMap.get(amount) == Integer.MAX_VALUE ? -1
                : dpMap.get(amount);
    }
}
