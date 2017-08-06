/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying.linkedlist;

import java.io.Serializable;

/**
 * @author cwenao
 * @version $Id LinkedInsertion.java, v 0.1 2017-08-06 23:08 cwenao Exp $$
 */
public class LinkedInsertion<T extends Comparable> implements Serializable {

    private LinkedNode<T> head;


    public LinkedNode<T> append(T data) {

        if (head == null) {
            head = new LinkedNode<T>(data);
            head.setNext(null);

            return head;
        }
        LinkedNode<T> node = new LinkedNode<T>(data);
        node.setNext(null);

        LinkedNode<T> tmp = head;
        while (tmp.getNext() != null) {
            tmp = tmp.getNext();
        }
        tmp.setNext(node);
        return node;
    }

    public void push(T data) {
        LinkedNode<T> node = new LinkedNode<T>(data);
        node.setNext(head);
        head = node;
    }

    public void insertAfter(LinkedNode<T> preNode, T data) {
        if (preNode == null) {
            return;
        }
        LinkedNode<T> node = new LinkedNode<T>(data);
        node.setNext(preNode.getNext());
        preNode.setNext(node);
    }

    private void printLinkedList() {
        LinkedNode<T> tmp = head;
        while (tmp != null) {
            System.out.println("This is the linked list node data: " + tmp.getData());
            tmp = tmp.getNext();
        }
    }

    public static void main(String[] args) {
        LinkedInsertion<Integer> linkedInsertion = new LinkedInsertion<>();
        linkedInsertion.append(22);
        linkedInsertion.append(90);


        linkedInsertion.push(30);


        linkedInsertion.insertAfter(linkedInsertion.head.getNext(), 8888);
        linkedInsertion.printLinkedList();

    }

}
