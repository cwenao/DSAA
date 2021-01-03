/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

import java.util.PriorityQueue;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id MedianFinder.java, v1.0.0 2021-01-02 11:30 cwenao Exp $$
 */
public class MedianFinder {

    private PriorityQueue<Integer> large;

    private PriorityQueue<Integer> small;

    /** initialize your data structure here. */
    public MedianFinder() {

        //小顶堆
        large = new PriorityQueue<>();

        //大顶堆
        small = new PriorityQueue<>((a,b) ->{
            return b - a;
        });
    }

    public void addNum(int num) {
        if (small.size() >= large.size()) {
            small.offer(num);
            large.offer(small.poll());
        } else {
            large.offer(num);
            small.offer(large.poll());
        }
    }

    public double findMedian() {

        if (small.size() > large.size()) {
            return small.peek();
        } else if (large.size() > small.size()) {
            return large.peek();
        }

        return (large.peek() + small.peek()) / 2.0;
    }
}
