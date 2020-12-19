/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id MaxCoins.java, v1.0.0 2020-12-19 21:29 cwenao Exp $$
 */
public class MaxCoins {

    public int maxCoins(int[] nums) {
        return maxCoinsByDP(nums);
    }

    private int maxCoinsByDP(int[] nums) {
        //dp[i][j]: 表示 （i,j）区间内的所能获取的最大值
        //k：k 表示 (i,j)间当前所打破的气球的位置
        //当打破k位置气球时所能获取K点的值为
        //currentSum[k] =  value[i] * value[k] * value[j]
        //currentMaxSum[k] = currentSum[k] + dp[i][k] + d[k][j]
        //dp[i][j] = Math.max(dp[i][j],currentMaxSum[k])

        int n = nums.length;
        //0与n+1为边界，因为（i,j）开区间
        int[][] dp = new int[n + 2][n + 2];
        int[] value = new int[n + 2];
        //最大的边界默认为1
        value[0] = value[n+1] = 1;
        for (int i = 1; i <= n; i++) {
            value[i] = nums[i-1];
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j <= n + 1; j++) {
                for (int k = i + 1; k < j; k++) {
                    int currentSum = value[i] * value[k] * value[j];
                    //当前区间最大值总和
                    currentSum += dp[i][k] + dp[k][j];
                    dp[i][j] = Math.max(dp[i][j], currentSum);
                }
            }
        }

        return dp[0][n+1];
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};
        MaxCoins maxCoins = new MaxCoins();
        System.out.println(maxCoins.maxCoins(nums));
    }
}
