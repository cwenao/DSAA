/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.second;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id Fibonacci.java, v1.0.0 2021-01-24 07:40 cwenao Exp $$
 */
public class Fibonacci {

    public int fib(int N) {

        if (N < 1) {
            return 0;
        }

//        int fibNum = fibByRecursive(N);
        int fibNum = fibByDP(N);

        return fibNum;
    }

    private int fibByDP(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        //dp[i] = dp[i-1]+dp[i-2]
        int[] dp = new int[n + 1];
        dp[1] = dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    private int fibByRecursive(int n) {
        int[] count = new int[n + 1];
        return fibByRecursiveTopAndDown(count, n);
    }

    private int fibByRecursiveTopAndDown(int[] count, int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (count[n] > 0) {
            return count[n];
        }
        count[n] = fibByRecursiveTopAndDown(count, n - 1) + fibByRecursiveTopAndDown(count, n - 2);
        return count[n];
    }



}
