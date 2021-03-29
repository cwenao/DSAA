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
 * @version $Id SuperEggDropI.java, v1.0.0 2021-03-29 22:26 cwenao Exp $$
 */
public class SuperEggDropI {

   private Map<Integer, Integer> memo = new HashMap<Integer, Integer>();


    public int superEggDrop(int K, int N) {

        if (K == 1) {
            return N;
        }
        if (N == 0) {
            return 0;
        }
        return superEggDropByDPAndBinarySearch(K, N);
    }

    private int superEggDropByDPAndBinarySearch(int k, int n) {

        //dp[k][n]: k个鸡蛋n层楼的最小移动次数
        //鸡蛋状态： 碎 -> dp[k-1][n-1],没碎 -> dp[k,N-n]
        // 取最大次数（最坏的情况 -> 鸡蛋破碎在最后一层楼）: Math.max(dp[k-1][n-1],dp[k,N-n])
        // dp[k][n] = Math.min(result,Math.max(dp[k-1][n-1],dp[k,N-n]))

        if (!memo.containsKey(n * 100 + k)) {
            int result = 0;
            if (n == 0) {
                result = 0;
            } else if (k == 1) {
                result = n;
            } else {
                int lo = 1, hi = n;
                while (lo + 1 < hi) {
                    int mid = (lo + hi) / 2;
                    //碎 -> dp[k-1][n-1]
                    int eggBroken = superEggDropByDPAndBinarySearch(k - 1, mid - 1);
                    //没碎 -> dp[k,N-n]
                    int eggNotBroken = superEggDropByDPAndBinarySearch(k, n - mid);

                    // 取最大次数（最坏的情况 -> 鸡蛋破碎在最后一层楼）: Math.max(dp[k-1][n-1],dp[k,N-n])
                    //往大的次数收敛
                    if (eggBroken < eggNotBroken) {
                        lo = mid;
                    } else if (eggBroken > eggNotBroken) {
                        hi = mid;
                    } else {
                        lo = hi = mid;
                    }
                }
                result = 1 + Math.min(Math.max(superEggDropByDPAndBinarySearch(k - 1, lo - 1),
                        superEggDropByDPAndBinarySearch(k, n - lo)),
                        Math.max(superEggDropByDPAndBinarySearch(k - 1, hi - 1),
                                superEggDropByDPAndBinarySearch(k, n - hi)));
            }
            memo.put(n * 100 + k, result);
        }

        return memo.get(n * 100 + k);
    }



}
