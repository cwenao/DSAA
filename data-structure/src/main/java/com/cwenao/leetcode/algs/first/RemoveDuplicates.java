/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id RemoveDuplicates.java, v1.0.0 2021-01-11 07:02 cwenao Exp $$
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        return removeDuplicatesByDoublePoint(nums);
    }

    private int removeDuplicatesByDoublePoint(int[] nums) {
        int slow = 0, fast = 0;

        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }

        return slow + 1;
    }

}
