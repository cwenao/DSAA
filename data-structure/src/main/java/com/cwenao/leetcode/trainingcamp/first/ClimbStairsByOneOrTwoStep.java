/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.trainingcamp.first;

/**
 * #70 . 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * @author cwenao
 * @version $Id ClimbStairs.java, v1.0.0 2020-11-24 14:10 cwenao Exp $$
 */
public class ClimbStairsByOneOrTwoStep {

    public int climbStairs(int n) {
        return climbStairsByRecursion(n);
    }

    /**
     * 递归：leetCode 超出时间限制
     * @param n
     * @return
     */
    private int climbStairsByRecursion(int n) {
        if (n <= 1) {
            return 1;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * DP：保存中间状态
     * 利用当前result 是下一台阶x的n-1
     * 当起n-1台阶为下一台阶x的n-2
     * @param n
     * @return
     */
    private int climbStairsByDP(int n) {

        int result = 1, oneStep = 0, twoStep = 0;

        for (int i = 1; i <= n; i++) {

            twoStep = oneStep;
            oneStep = result;
            result = oneStep + twoStep;
        }

        return result;
    }

    private int climbStairsByDPII(int n) {
        //dp[i]: 表示n[0:i]台阶方法次数
        int[] dp = new int[n + 1];
        dp[0] =1;
        dp[1] =1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        ClimbStairsByOneOrTwoStep climbStairs = new ClimbStairsByOneOrTwoStep();
        System.out.println(climbStairs.climbStairs(44));
        System.out.println(climbStairs.climbStairsByDP(44));
        System.out.println(climbStairs.climbStairsByDPII(44));
    }

}
