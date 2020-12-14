/**
 * Company Copyright (C) 2014-2019 All Rights Reserved.
 */
package com.cwenao.leetcode.hundred.first;

/**
 * LeetCode
 * #237. 删除链表中的节点
 * 删除某个链表中给定的（非末尾）节点。
 *
 * 现有链表 - LinkedList = [4,5,2,9]，表示为:
 * 4->5->2->9
 *
 */
public class LinkedListNodeDeleted {
    public void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }
        ListNode nextNode = node.next;
        node.next = nextNode.next;
        node.val = nextNode.val;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        LinkedListNodeDeleted llnd = new LinkedListNodeDeleted();
        ListNode node = null;
        ListNode tmp = node1;
        int index = 4;
        while (node1.next != null) {
            if (node1.val == index) {
                node = node1;
                break;
            }
            tmp = tmp.next;
        }

        llnd.deleteNode(node);

        ListNode tmp1 = node1;

        while (Integer.valueOf( tmp1.val)!=null) {
            System.out.println(tmp1.val);
            tmp1 = tmp1.next;
        }
    }
}
