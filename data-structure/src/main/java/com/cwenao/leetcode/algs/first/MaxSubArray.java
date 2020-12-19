/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id MaxSubArray.java, v1.0.0 2020-12-18 15:41 cwenao Exp $$
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        return maxSubArrayByDP(nums);
    }

    private int maxSubArrayByDP(int[] nums) {

        //dp[i]: 已当前元素nums[i]结束的最大连续数组的和
        //dp[i] = Math.max(nums[i],dp[i-1]+nums[i]);

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
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
        MaxSubArray maxSubArray = new MaxSubArray();
        System.out.println(maxSubArray.maxSubArray(nums));
    }

}
