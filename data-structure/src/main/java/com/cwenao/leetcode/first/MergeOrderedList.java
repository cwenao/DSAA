/**
 * Company Copyright (C) 2014-2019 All Rights Reserved.
 */
package com.cwenao.leetcode.first;

/**
 *
 * #21. 合并两个有序链表
 * 利用哨兵机制
 * 1. ListNode为对象，在哨兵对象sentry对pre赋值时对象为同一个地址
 * 2. pre.next = l1时 sentry的next = l1
 * 3. pre = pre.next时，l1或者l2的地址等同于pre
 * @author cwenao
 * @version $Id MergeOrderedNodeList.java, v1.0.0 2019-08-17 17:11 cwenao Exp $$
 */
public class MergeOrderedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode sentry = new ListNode(-1);

        ListNode pre = sentry;

        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }

        pre.next = l1 == null ? l2 : l1;

        return sentry.next;
    }

    public static void main(String[] args) {
        ListNode sentry = new ListNode(-1);

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

    }
}
