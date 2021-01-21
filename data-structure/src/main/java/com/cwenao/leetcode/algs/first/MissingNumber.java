/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id MissingNumber.java, v1.0.0 2021-01-21 19:57 cwenao Exp $$
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;

        int missingNum = n;
        for (int i = 0; i < n; i++) {
            missingNum = missingNum ^ (i ^ nums[i]);
        }

        return missingNum;
    }

    public static void main(String[] args) {
        MissingNumber missingNumber = new MissingNumber();
        int[] test = new int[]{0, 3, 1, 4};
        System.out.println(missingNumber.missingNumber(test));

    }
}
