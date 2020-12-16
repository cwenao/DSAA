/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id HouseRobberII.java, v1.0.0 2020-12-15 17:44 cwenao Exp $$
 */
public class HouseRobberII {

    public int rob(int[] nums) {

        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
//        return Math.max(houseRobberByRange(nums, 0, n - 2),
//                houseRobberByRange(nums, 1, n - 1));
        Map<Integer,Integer> existingMap = new HashMap<>();
        Map<Integer,Integer> existingMap2 = new HashMap<>();

        return Math.max(houseRobberByRangeRecursive(nums, 0, n - 2,existingMap),
                houseRobberByRangeRecursive(nums, 1, n - 1,existingMap2));
    }

    private int houseRobberByRangeRecursive(int[] nums, int start, int end,
            Map<Integer, Integer> existingMap) {

        if (start > end) {
            return 0;
        }

        if (existingMap.containsKey(start)) {
            return existingMap.get(start);
        }
        int result = Math.max(houseRobberByRangeRecursive(nums, start + 1, end, existingMap)
                , nums[start] + houseRobberByRangeRecursive(nums, start + 2, end, existingMap));

        existingMap.put(start, result);

        return result;
    }

    private int houseRobberByRange(int[] nums, int start, int end) {

        int dp_i = 0;
        int dp_i_1 = 0;
        int dp_i_2 = 0;

        for (int i = end; i >= start; i--) {
            dp_i = Math.max(dp_i_1, nums[i] + dp_i_2);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }

        return dp_i;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,1};
        HouseRobberII houseRobberII = new HouseRobberII();
        System.out.println(houseRobberII.rob(nums));
    }
}
