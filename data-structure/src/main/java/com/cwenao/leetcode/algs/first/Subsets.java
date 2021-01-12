/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id Subsets.java, v1.0.0 2021-01-12 08:59 cwenao Exp $$
 */
public class Subsets {

    private LinkedList<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {

        LinkedList<Integer> trackList = new LinkedList<>();

        subsetsByBacktracking(nums,0, trackList);

        return result;
    }

    private void subsetsByBacktracking(int[] nums, Integer start, LinkedList<Integer> trackList) {

        //递归 选择完成
        result.add(new LinkedList<>(trackList));

        for (int i = start; i < nums.length; i++) {

            trackList.add(nums[i]);
            subsetsByBacktracking(nums,i+1, trackList);
            trackList.removeLast();
        }
    }

}
