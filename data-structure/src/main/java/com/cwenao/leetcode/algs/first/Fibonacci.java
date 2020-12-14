/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id Fibonacci.java, v1.0.0 2020-12-11 07:44 cwenao Exp $$
 */
public class Fibonacci {

    public int fib(int N) {

        if (N < 1) {
            return 0;
        }
//        int fibNum = fibByTopDown(N);
        int fibNum = fibByBottomUp(N);

        return fibNum;
    }

    /**
     * 自顶向下递归
     * @param n
     * @return
     */
    private int fibByTopDown(int n) {

        //暴力递归：fibByTopDown(n-1)+fibByTopDown(n-2)
        //中间状态：检测是否已存在n-1或者n-2
        int[]  dp= new int[n+1];
        return topDownCount(dp,n);
    }

    private int topDownCount(int[] dp, int n) {

        if (n == 1 || n == 2) {
            return 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = topDownCount(dp, n - 1) + topDownCount(dp, n - 2);
        return dp[n];
    }

    /**
     * 自底向上构建DP table
     * @param n
     * @return
     */
    private int fibByBottomUp(int n) {

        if (n == 1 || n == 2) {
            return 1;
        }

        //自底向上：构建 DP table
        int[] dp = new int[n + 1];

        dp[1] = dp[2] = 1;
        for (int i = 3; i < dp.length; i++) {

            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }



    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fib(10));
    }

}
