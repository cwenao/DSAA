/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id FindTargetSumWaysByDP.java, v1.0.0 2020-12-16 08:47 cwenao Exp $$
 */
public class FindTargetSumWaysByDP {

    int result = 0;
    public int findTargetSumWays(int[] nums, int S) {
//        return findTargetSumWaysByBacktracking(nums, S);
       findTargetSumWaysByDP(nums,0, S);
        return result;
    }

    private void findTargetSumWaysByDP(int[] nums,int i, int target) {

        if (i == nums.length) {
            if (target == 0) {
                result++;
            }
            return;
        }



    }


    private int findTargetSumWaysByBacktracking(int[] nums, int s) {

        if (nums.length == 0) {
            return result;
        }

        backtracking(nums, 0, s);

        return result;
    }

    private void backtracking(int[] nums, int i, int target) {

        if (i == nums.length) {
            if (target == 0) {
                result++;
            }
            return;
        }
        //状态转移方程
        //dp[i][j] 表示 0...i的和为 j 的个数
        //dp[i][j] 可以由 i-1且和为(j+nums[i])+(j-nums[i])得到的得到
        //dp[i-1][j-nums[i]] 、 dp[i-1][j+nums[i]]
        //============>
        //dp[i][j] = dp[i-1][j-nums[i]] + dp[i-1][j+nums[i]]
        //得到递推公式=====>
        //dp[i][j-nums[i]] = dp[i-1][j] + dp[i][j-nums[i]]
        //dp[i][j+nums[i]] = dp[i-1][j] + dp[i][j+nums[i]]

        target += nums[i];
        backtracking(nums, i + 1, target);
        target -= nums[i];

        target -= nums[i];
        backtracking(nums, i + 1, target);
        target += nums[i];
    }

    public static void main(String[] args) {
        int[] nums=  {1, 1, 1, 1, 1};
        int S = 3;
        FindTargetSumWaysByDP findTargetSumWaysByDP = new FindTargetSumWaysByDP();
        System.out.println(findTargetSumWaysByDP.findTargetSumWays(nums, S));
    }
}
