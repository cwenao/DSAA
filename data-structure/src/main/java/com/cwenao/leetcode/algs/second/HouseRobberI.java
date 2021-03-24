/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.second;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id HouseRobberI.java, v1.0.0 2021-03-23 08:11 cwenao Exp $$
 */
public class HouseRobberI {

    public int rob(int[] nums) {
        return robByDP(nums);
    }

    private int robByDP(int[] nums) {

        //dp[i]: 偷第i间房后所获得的最大金额
        //如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警
        //dp[i] = Math.max(dp[i+1],nums[i]+dp[i+2])
        int n = nums.length;
        int[] dp = new int[n + 2];
        dp[n] = 0;
        dp[n + 1] = 0;
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
        }

        return dp[0];
    }

    public static void main(String[] args) {
        int[] houses = {1, 2, 3, 1};
        HouseRobberI houseRobberI = new HouseRobberI();
        System.out.println(houseRobberI.rob(houses));

    }
}
