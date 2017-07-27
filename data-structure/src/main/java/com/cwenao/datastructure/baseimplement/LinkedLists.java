/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure.baseimplement;

/**
 * @author cwenao
 * @version $Id LinkedLists.java, v 0.1 2017-07-10 8:15 cwenao Exp $$
 */
public class LinkedLists {

    class Node {
        Node next = null;
        int data;

        public Node(int data) {
            this.data = data;
        }

    }

    private Node head = null;

    public void addNode(int data) {
        Node currentNode = new Node(data);
        if (head == null) {
            head = currentNode;
            return;
        }

        Node nextNode = head;
        while (nextNode.next != null) {
            nextNode = nextNode.next;
        }
        nextNode.next = currentNode;

    }

    public int size() {
        int len = 0;
        if (head == null) {
            return len;
        }
        len = 1;
        Node nextNode = head;

        while (nextNode.next != null) {
            nextNode = nextNode.next;
            len++;
        }
        return len;

    }

    public boolean removeNode(int index) {
        if (index < 0 && index > size()) {
            return Boolean.FALSE;
        }

        Node currentNode = node(index);
        Node preNode = null;

        if (index == 0) {
            head = currentNode;
        } else {
            preNode = node(index - 1);
            preNode.next = currentNode.next;
            currentNode.next = null;
        }

        return Boolean.TRUE;
    }

    Node node(int index) {
        Node nextNode = head;
        for (int i=0;i<index;i++) {
            nextNode = nextNode.next;
        }
        return nextNode;
    }

    public static void main(String[] args) {
        LinkedLists linkedLists = new LinkedLists();
        System.out.println(linkedLists.size());
        linkedLists.addNode(1);
        linkedLists.addNode(2);
        linkedLists.addNode(3);

        System.out.println(linkedLists.size());
        linkedLists.removeNode(2);
        System.out.println(linkedLists.size());
    }
}

