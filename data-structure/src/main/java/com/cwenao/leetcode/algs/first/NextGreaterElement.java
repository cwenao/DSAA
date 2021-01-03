/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id NextGreaterElement.java, v1.0.0 2021-01-03 09:05 cwenao Exp $$
 */
public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> result = nextGreaterElementByStack(nums2);
        int[] nextGreater = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            nextGreater[i] = result.getOrDefault(nums1[i],-1);
        }

        return nextGreater;
    }

    private Map<Integer, Integer> nextGreaterElementByStack(int[] nums2) {

        Map<Integer, Integer> resultMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = nums2.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }

            resultMap.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }

        return resultMap;
    }
}
