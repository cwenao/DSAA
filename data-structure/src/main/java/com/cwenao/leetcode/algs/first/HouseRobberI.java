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
 * @version $Id HouseRobberI.java, v1.0.0 2020-12-15 17:06 cwenao Exp $$
 */
public class HouseRobberI {

    public int rob(int[] nums) {
        Map<Integer,Integer> existingMap = new HashMap<>();
        return robByDP(nums,0,existingMap);
    }

    private int robByDP(int[] nums,int start,Map<Integer, Integer> existingMap) {

        if (start >= nums.length) {
            return 0;
        }

        if (existingMap.containsKey(start)) {
            return existingMap.get(start);
        }

        int result = Math.max(robByDP(nums, start + 1, existingMap),
                nums[start] + robByDP(nums, start + 2, existingMap));

        existingMap.put(start, result);

        return result;
    }

    public static void main(String[] args) {
        int[] houses = {1, 2, 3, 1};
        HouseRobberI houseRobberI = new HouseRobberI();
        System.out.println(houseRobberI.rob(houses));
    }

}
