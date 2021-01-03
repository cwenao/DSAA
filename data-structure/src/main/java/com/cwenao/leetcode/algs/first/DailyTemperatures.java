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
 * @version $Id DailyTemperatures.java, v1.0.0 2021-01-03 09:44 cwenao Exp $$
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {
        return dailyTemperaturesByStack(T);
    }

    private int[] dailyTemperaturesByStack(int[] t) {
        int[] result = new int[t.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = t.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && t[stack.peek()] <= t[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? 0 : (stack.peek() - i);
            stack.push(i);
        }

        return result;
    }

}
