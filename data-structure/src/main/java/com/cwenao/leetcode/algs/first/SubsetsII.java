/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id SubsetsII.java, v1.0.0 2021-01-12 09:24 cwenao Exp $$
 */
public class SubsetsII {

    private LinkedList<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        LinkedList<Integer> trackList = new LinkedList<>();
        Arrays.sort(nums);

        subsetsWithDupByBacktracking(nums, 0, trackList);

        return result;
    }

    private void subsetsWithDupByBacktracking(int[] nums, Integer start, LinkedList<Integer> trackList) {

        result.add(new LinkedList<>(trackList));

        for (int i = start; i < nums.length; i++) {
            //跳过同层重复数字
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            trackList.add(nums[i]);
            subsetsWithDupByBacktracking(nums,i+1,trackList);
            trackList.removeLast();
        }
    }
}
