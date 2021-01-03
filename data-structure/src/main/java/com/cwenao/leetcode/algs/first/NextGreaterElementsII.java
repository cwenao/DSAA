/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

import java.util.Stack;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id NextGreaterElementsII.java, v1.0.0 2021-01-03 09:57 cwenao Exp $$
 */
public class NextGreaterElementsII {
    public int[] nextGreaterElements(int[] nums) {

        return nextGreaterElementsByStack(nums);

    }

    private int[] nextGreaterElementsByStack(int[] nums) {

        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        int len = nums.length;

        for (int i = 2 * len - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() <= nums[i % len]) {
                stack.pop();
            }

            result[i % len] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % len]);
        }

        return result;
    }
}
