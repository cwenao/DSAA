/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id MaxSlidingWindow.java, v1.0.0 2021-01-05 14:12 cwenao Exp $$
 */
public class MaxSlidingWindow {

    private Deque<Integer> deque = new LinkedList<>();

    public int[] maxSlidingWindow(int[] nums, int k) {

        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                queueAdd(nums[i]);
            } else {
                queueAdd(nums[i]);
                results.add(deque.peekFirst());
                queuePop(nums[i - k + 1]);
            }
        }

        return results.stream().mapToInt(s -> s.intValue()).toArray();
    }

    private void queuePop(int num) {
        if (num == deque.peekFirst()) {
            deque.pollFirst();
        }
    }

    private void queueAdd(int num) {
        while (!deque.isEmpty() && deque.peekLast() < num) {
            deque.pollLast();
        }
        deque.offerLast(num);
    }

}
