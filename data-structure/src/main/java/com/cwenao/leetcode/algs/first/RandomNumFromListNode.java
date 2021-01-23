/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

import java.util.Random;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id RandomNumFromListNode.java, v1.0.0 2021-01-22 09:07 cwenao Exp $$
 */
public class RandomNumFromListNode {

    private Random random;

    private ListNode node;

    /**
     * @param head The linked list's head. Note that the head is guaranteed to be not null, so it
     * contains at least one node.
     */
    public RandomNumFromListNode(ListNode head) {
        this.random = new Random();
        this.node = head;
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {

        int result = 0;
        int index = 0;
        ListNode p = node;
        while (p != null) {
            // 生成一个 [0, i) 之间的整数
            // 这个整数等于 0 的概率就是 1/i
            if (random.nextInt(++index) == 0) {
                result = p.val;
            }
            p = p.next;
        }

        return result;
    }

    public class ListNode{

        int val;
        ListNode next;
        ListNode(){}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
