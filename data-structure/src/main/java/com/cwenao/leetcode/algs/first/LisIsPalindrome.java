/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id LisIsPalindrome.java, v1.0.0 2020-12-22 08:27 cwenao Exp $$
 */
public class LisIsPalindrome {

    private ListNode left;

    public boolean isPalindrome(ListNode head) {
        left = head;
        return reverse(head);
    }

    private boolean reverse(ListNode right) {
        if (right == null) {
            return true;
        }

        boolean result = reverse(right.next);

        result = result && (left.val == right.val);
        left = left.next;

        return result;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
