/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.second;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id MaxSubArray.java, v1.0.0 2021-03-30 08:16 cwenao Exp $$
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        return maxSubArrayByDP(nums);
    }

    private int maxSubArrayByDP(int[] nums) {
        //dp[i]: 以当前nums[i]结束的最大子序列和
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];

        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }
        int result = Integer.MIN_VALUE;
        for (int x : dp) {
            result = Math.max(result, x);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        com.cwenao.leetcode.algs.first.MaxSubArray maxSubArray = new com.cwenao.leetcode.algs.first.MaxSubArray();
        System.out.println(maxSubArray.maxSubArray(nums));
    }

}
