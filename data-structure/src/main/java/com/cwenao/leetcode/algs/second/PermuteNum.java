/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.second;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id PermuteNum.java, v1.0.0 2021-03-18 08:55 cwenao Exp $$
 */
public class PermuteNum {

    private List<List<Integer>> result;

    public List<List<Integer>> permute(int[] nums) {

        List<Integer> track = new LinkedList<>();
        result = new ArrayList<>();

        permuteByBacktrack(nums, track);

        return result;
    }

    private void permuteByBacktrack(int[] nums, List<Integer> track) {

        if (track.size() == nums.length) {
            result.add(track);
            return;
        }

        for (Integer num : nums) {
            if (track.contains(num)) {
                continue;
            }
            track.add(num);
            permuteByBacktrack(nums, track);
            track.remove(num);
        }

    }
}
