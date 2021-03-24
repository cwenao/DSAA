/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.second;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id HouseRobberII.java, v1.0.0 2021-03-23 08:45 cwenao Exp $$
 */
public class HouseRobberII {

    public int rob(int[] nums) {
        return robIIByDP(nums);
    }

    private int robIIByDP(int[] nums) {

        //dp[i]: 获取第i间房后所获取的最大利润
        //是否偷第i间房则取决于第i+1，i+2间房的金钱
        //dp[i] = Math.max(dp[i+1],nums[i]+dp[i+2])

        //这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的
        int n = nums.length;
//        int[] dp1 = new int[n + 2];
//        dp1[n] = 0;
//        dp1[n + 1] = 0;
//
//        int[] dp2 = new int[n + 2];
//        dp2[n] = 0;
//        dp2[n + 1] = 0;
//
//        //第一间房不偷，最后间房偷
//        for (int i = n - 1; i >= 1; i--) {
//            dp1[i] = Math.max(dp1[i + 1], nums[i] + dp1[i + 2]);
//        }
//        //最后间房不偷，第一间房偷
//        for (int i = n - 2; i >= 0; i--) {
//            dp2[i] = Math.max(dp2[i + 1], dp2[i + 2] + nums[i]);
//        }

        return Math.max(dp(nums, 1, n - 1, n), dp(nums, 0, n - 2, n));
    }

    private int dp(int[] nums, int start, int end,int len) {

        int[] dp = new int[len + 2];
        dp[len] = 0;
        dp[len + 1] = 0;

        for (int i = end; i >= start; i--) {
            dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
        }
        return dp[start];
    }


    public static void main(String[] args) {
        int[] nums = {1,2,1,1};
        HouseRobberII houseRobberII = new HouseRobberII();
        System.out.println(houseRobberII.rob(nums));
    }
}
