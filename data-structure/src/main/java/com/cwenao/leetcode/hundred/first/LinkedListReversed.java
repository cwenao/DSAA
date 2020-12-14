/**
 * Company Copyright (C) 2014-2019 All Rights Reserved.
 */
package com.cwenao.leetcode.hundred.first;

/**
 *
 * 206. 反转链表
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * @author cwenao
 * @version $Id LinkedListReversed.java, v1.0.0 2019-07-11 09:28 cwenao Exp $$
 */
public class LinkedListReversed {

    public ListNode reverseList(ListNode head) {

        if (head == null || head.next==null) {
            return head;
        }
        ListNode tmp = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return tmp;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        LinkedListReversed linkedListReversed = new LinkedListReversed();
        ListNode listNode = linkedListReversed.reverseList(node1);
        System.out.println(listNode);

    }

}
