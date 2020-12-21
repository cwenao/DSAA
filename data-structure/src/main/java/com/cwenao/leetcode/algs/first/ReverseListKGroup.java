/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id ReverseListKGroup.java, v1.0.0 2020-12-22 06:34 cwenao Exp $$
 */
public class ReverseListKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null) {
            return null;
        }
        ListNode current = head, next = head;
        for (int i = 0; i < k; i++) {
            if (next == null) {
                return head;
            }
            next = next.next;
        }
        ListNode newHead = reverse(current, next);
        current.next = reverseKGroup(next, k);

        return newHead;
    }

    private ListNode reverse(ListNode current, ListNode next) {

        ListNode pre = null, currentK = current, nextK = current;

        while (currentK != next) {

            nextK = currentK.next;
            currentK.next = pre;
            pre = currentK;
            currentK = nextK;
        }

        return pre;
    }

    public class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
