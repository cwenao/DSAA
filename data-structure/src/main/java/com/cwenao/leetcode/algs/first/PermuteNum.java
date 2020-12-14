/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id PermuteNum.java, v1.0.0 2020-12-11 13:03 cwenao Exp $$
 */
public class PermuteNum {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer>  track= new LinkedList<>();

        permuteByList(nums, result, track);

        return result;
    }

    private void permuteByList(int[] nums, List<List<Integer>> result, List<Integer> track) {

        if (nums.length == track.size()) {
            result.add(new LinkedList<>(track));
            return;
        }

        for (Integer num : nums) {
            if (track.contains(num)) {
                continue;
            }
            track.add(num);
            permuteByList(nums, result, track);
            track.remove(num);
        }
    }

    public static void main(String[] args) {
        PermuteNum permuteNum = new PermuteNum();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> result = permuteNum.permute(nums);
        for (List<Integer> list : result) {
            StringBuffer sb = new StringBuffer();

            for (Integer num : list) {
                sb.append(num);
            }
            System.out.println(sb.toString());

        }
    }
}
