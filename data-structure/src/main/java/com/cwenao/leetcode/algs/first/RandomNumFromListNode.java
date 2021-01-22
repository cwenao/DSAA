/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

import java.util.List;
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

        while (node != null) {
            if (random.nextInt(++index) == 0) {
                result = node.val;
            }
            node = node.next;
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
