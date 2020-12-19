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
 * @version $Id SuperEggDropI.java, v1.0.0 2020-12-19 18:30 cwenao Exp $$
 */
public class SuperEggDropI {

    private Map<Integer, Integer> dpMap = new HashMap<>();

    public int superEggDrop(int K, int N) {
        return superEggDropByDPAndBinarySearch(K, N);
    }

    /**
     * 递归+备忘录：lettcode超出时间限制
     * @param k
     * @param n
     * @return
     */
    private int superEggDropByDP(int k, int n) {

        //dp[k,n]: k个鸡蛋n层楼的最小移动次数
        //鸡蛋状态：碎 ->dp[k-1,n-1]、没碎->dp[k,K-n]
        //max(dp[k-1,n-1],dp[k,N-n]):  取当前状态的最大需要次数，保证最坏情况
        //dp[k][n] = min(result,max(dp[k-1,n-1],dp[k,N-n]))

        if (k == 1) {
            return n;
        }
        if (n == 0) {
            return 0;
        }

        if (dpMap.containsKey(n * 100 + k)) {
            return dpMap.get(n * 100 + k);
        }
        int result = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            result = Math.min(result,
                    Math.max(superEggDropByDP(k - 1, i - 1), superEggDropByDP(k, n - i))+1);
        }
        dpMap.put(n * 100 + k, result);
        return result;
    }

    private int superEggDropByDPAndBinarySearch(int k, int n) {

        if (dpMap.containsKey(n * 100 + k)) {
            return dpMap.get(n * 100 + k);
        }else {
            int result;
            if (n == 0) {
                result = 0;
            }else if (k == 1) {
                result = n;
            }else {

                int low = 1, high = n;

                while (low + 1 < high) {
                    int mid = (low + high) / 2;
                    int eggBroken = superEggDropByDPAndBinarySearch(k - 1, mid - 1);
                    int eggNotBroken = superEggDropByDPAndBinarySearch(k, n - mid);

                    if (eggBroken < eggNotBroken) {
                        low = mid;
                    } else if (eggBroken > eggNotBroken) {
                        high = mid;
                    } else {
                        low = high = mid;
                    }
                }
                result = 1 + Math.min(Math.max(superEggDropByDPAndBinarySearch(k - 1, low - 1)
                        , superEggDropByDPAndBinarySearch(k, n - low)),
                        Math.max(superEggDropByDPAndBinarySearch(k - 1, high - 1)
                                , superEggDropByDPAndBinarySearch(k, n - high)));
            }
            dpMap.put(n * 100 + k, result);
            return result;
        }
    }

    Map<Integer, Integer> memo = new HashMap();
    public int dp(int K, int N) {
        if (!memo.containsKey(N * 100 + K)) {
            int ans;
            if (N == 0) {
                ans = 0;
            } else if (K == 1) {
                ans = N;
            } else {
                int lo = 1, hi = N;
                while (lo + 1 < hi) {
                    int x = (lo + hi) / 2;
                    int t1 = dp(K-1, x-1);
                    int t2 = dp(K, N-x);

                    if (t1 < t2) {
                        lo = x;
                    } else if (t1 > t2) {
                        hi = x;
                    } else {
                        lo = hi = x;
                    }
                }

                ans = 1 + Math.min(Math.max(dp(K - 1, lo - 1), dp(K, N - lo)), Math.max(dp(K - 1, hi - 1), dp(K, N - hi)));
            }

            memo.put(N * 100 + K, ans);
        }

        return memo.get(N * 100 + K);
    }

    public static void main(String[] args) {
        int K = 3, N = 14;
        SuperEggDropI superEggDropI = new SuperEggDropI();
        System.out.println(superEggDropI.superEggDrop(K, N));
    }
}
