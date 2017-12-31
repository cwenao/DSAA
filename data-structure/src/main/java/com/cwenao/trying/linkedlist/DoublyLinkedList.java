/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying.linkedlist;

/**
 * @author cwenao
 * @version $Id DoublyLinkedList.java, v 0.1 2017-12-28 07:34 cwenao Exp $$
 */
public class DoublyLinkedList {

    Node head;
    class Node{
        int data;
        Node pre;
        Node next;

        Node(int data) {
            this.data = data;
        }

    }

    public void push(int data) {
        Node addNode = new Node(data);
        addNode.next = head;
        addNode.pre = null;

        if (head !=null) {
            head.pre = addNode;
        }
        head = addNode;
    }

    public void insertAfter(Node current, int data) {
        Node newNode = new Node(data);
        Node currentNextNode = current.next;

        current.next = newNode;
        newNode.next = currentNextNode;
        newNode.pre = current;
        if (currentNextNode!=null) {
            currentNextNode.pre = newNode;
        }
    }

    public void deleteNodeWithKey(int key) {
        Node tmp = head;
        Node pre = null;
        if (tmp != null && tmp.data == key) {
            head = tmp.next;
            head.pre = null;
            return;
        }

        while (tmp != null && tmp.data != key) {
            pre = tmp;
            tmp = tmp.next;
        }

        if (tmp == null) {
            return;
        }
        Node nextTmp = tmp.next;
        pre.next = nextTmp;
        nextTmp.pre = pre;

    }

    public void deleteNodeWithPosition(int position) {

        if (head == null) {
            return;
        }
        Node tmp = head;

        if (position == 0) {
            head = tmp.next;
            head.pre = null;
            return;
        }

        for (int i = 0; i<position -1;i++) {
            tmp = tmp.next;
        }

        if (tmp == null || tmp.next == null) {
            return;
        }
        Node nextTmp = tmp.next.next;
        tmp.next = nextTmp;
        nextTmp.pre = tmp;
    }

}
