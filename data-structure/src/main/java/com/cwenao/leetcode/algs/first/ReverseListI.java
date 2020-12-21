/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id ReverseListI.java, v1.0.0 2020-12-20 14:58 cwenao Exp $$
 */
public class ReverseListI {

    public ListNode reverseList(ListNode head) {
        return reverseListByRecursive(head);
    }

    private ListNode reverseListByRecursive(ListNode head) {

        if (head.next == null) {
            return head;
        }
        ListNode result = reverseListByRecursive(head.next);
        //开始递归时head = 5，
        head.next.next = head;
        head.next = null;

        return result;
    }


    public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
    }

}
