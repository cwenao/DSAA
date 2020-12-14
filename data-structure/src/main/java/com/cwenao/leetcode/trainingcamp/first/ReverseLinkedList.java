/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.trainingcamp.first;

/**
 * #206. 反转链表
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * @author cwenao
 * @version $Id ReverseLinkedList.java, v1.0.0 2020-12-03 09:34 cwenao Exp $$
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {

        ListNode p = reverseListByRecursive(head);

        return p;
    }

    /**
     * 递归法
     * @param head
     * @return
     */
    private ListNode reverseListByRecursive(ListNode head) {

        //head == 5则结束 recursive
        if (head == null || head.next == null) {
            return head;
        }

        //head == 4,head.next == 5
        //依次递归
        ListNode tmp = reverseListByRecursive(head.next);

        //head.next == 5, 5.next = 4
        //依次递归
        head.next.next = head;

        //删除现有head.next
        head.next = null;

        return tmp;
    }

    /**
     * 双指针法
     * @param head
     * @return
     */
    private ListNode reverseListByDoublePoint(ListNode head) {

        ListNode tmp = null;
        ListNode currentNode = head;
        ListNode preNode = null;

        while (currentNode != null) {
            tmp = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = tmp;
        }

        return preNode;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
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

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();

//        while (node1 != null) {
//            System.out.println("source----> "+node1.val);
//            node1 = node1.next;
//        }

        ListNode result = reverseLinkedList.reverseListByDoublePoint(node1);

        while (result != null) {
            System.out.println("target---->"+result.val);
            result = result.next;
        }

    }

}
