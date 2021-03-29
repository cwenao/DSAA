/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.second;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id MaxCoins.java, v1.0.0 2021-03-29 23:11 cwenao Exp $$
 */
public class MaxCoins {

    public int maxCoins(int[] nums) {
        return maxCoinsByDP(nums);
    }

    private int maxCoinsByDP(int[] nums) {

        //dp[i][j]: 区间(i,j)之间所能获取的最大值
        //k: 当前在区间(i,j)打破气球的位置
        //在位置k打破气球后所获取的值为
        //currentSum[k] = nums[k-1]*nums[k]*nums[k+1]
        //当前区间(i,j)最大值
        //currentMaxSum[k] = currentSum[k] + dp[i][k] +dp[k][j]
        //dp[i][j] = Math.max(dp[i][j],currentMaxSum[k])

        int n = nums.length;
        //0与n+1为边界，因为（i,j）开区间
        int[][] dp = new int[n + 2][n + 2];
        int[] value = new int[n + 2];

        value[0] = value[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            value[i] = nums[i - 1];
        }

        //在位置k打破气球后所获取的值为
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j <= n; j++) {
                for (int k = i + 1; k < j; k++) {
                    //currentSum[k] = nums[k-1]*nums[k]*nums[k+1]
                    int currentSum = value[i] * value[k] * value[j];
                    //当前区间(i,j)最大值
                    //currentMaxSum[k] = currentSum[k] + dp[i][k] +dp[k][j]
                    currentSum += dp[i][k] + dp[k][j];
                    dp[i][j] = Math.max(dp[i][j], currentSum);
                }
            }
        }

        return dp[0][n + 1];
    }




}
