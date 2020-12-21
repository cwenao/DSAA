/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;



/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id ReverseListII.java, v1.0.0 2020-12-20 15:41 cwenao Exp $$
 */
public class ReverseListII {

    private ListNode nextNode = null;

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n);
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    private ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            nextNode = head.next;
            return head;
        }
        ListNode lastNode = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = nextNode;
        return lastNode;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


}
