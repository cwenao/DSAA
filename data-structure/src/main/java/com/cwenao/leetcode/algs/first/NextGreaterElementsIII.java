/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

import java.util.Arrays;
import java.util.Stack;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id NextGreaterElementsIII.java, v1.0.0 2021-01-03 10:37 cwenao Exp $$
 */
public class NextGreaterElementsIII {

    public int nextGreaterElement(int n) {
        if (n >= Integer.MAX_VALUE) {
            return -1;
        }
        return nextGreaterElementByStack(n);
    }

    private int nextGreaterElementByStack(int n) {
        char[] nums = ("" + n).toCharArray();
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = nums.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() <= (nums[i] - 'a')) {
                stack.pop();
            }

            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i] - 'a');
        }
        for (int i = result.length - 1; i >= 0; i--) {

            if (result[i] != -1) {
                for (int j = nums.length - 1; j > i; j--) {
                    swapNums(nums, j, i);
                    String res = String.valueOf(nums);

                    if (n < Long.parseLong(res)) {
                        char[] tmp = Arrays.copyOfRange(nums, i + 1, nums.length);
                        Arrays.sort(tmp);
                        for (int k = 0; k < tmp.length; k++) {
                            nums[i + 1 + k] = tmp[k];
                        }
                        if (Long.valueOf(String.valueOf(nums)) > Integer.MAX_VALUE) {
                            return -1;
                        }
                        return Integer.parseInt(String.valueOf(nums));
                    }
                }
            }
        }

        return -1;
    }

    private void swapNums(char[] nums, int j, int i) {
        char tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }

    public static void main(String[] args) {
        NextGreaterElementsIII nextGreaterElementsIII = new NextGreaterElementsIII();
        System.out.println(nextGreaterElementsIII.nextGreaterElement(12443322));

    }


}
