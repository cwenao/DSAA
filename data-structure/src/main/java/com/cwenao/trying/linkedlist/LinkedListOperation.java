/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying.linkedlist;

import java.io.Serializable;

/**
 * @author cwenao
 * @version $Id LinkedListOperation.java, v 0.1 2017-08-06 23:08 cwenao Exp $$
 */
public class LinkedListOperation<T extends Comparable> implements Serializable {

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

    /**
     * the size of linked list
     * @return
     */
    public int size() {
        return size(head);
    }

    private int size(LinkedNode<T> node) {
        if (node == null) {
            return 0;
        }
        return 1 + size(node.getNext());
    }

    /**
     * 判断是否存在当前给出的data的node
     * @param data
     * @return
     */
    public boolean contains(T data) {
        return contains(head, data);
    }

    private boolean contains(LinkedNode<T> node, T data) {
        if (node == null) {
            return false;
        }
        if (node.getData().compareTo(data) == 0) {
            return true;
        }
        return contains(node.getNext(), data);
    }

    /**
     * 查找当前的Node并返回
     * @param data
     * @return
     */
    public LinkedNode<T> search(T data) {
        return search(head, data);
    }

    private LinkedNode<T> search(LinkedNode<T> node, T data) {
        if (node == null) {
            return null;
        }
        if (node.getData().compareTo(data) == 0) {
            return node;
        }
        return search(node.getNext(), data);
    }

    public void insertAfter(LinkedNode<T> preNode, T data) {
        if (preNode == null) {
            return;
        }
        LinkedNode<T> node = new LinkedNode<T>(data);
        node.setNext(preNode.getNext());
        preNode.setNext(node);
    }



    public void deleteNode(T data) {
        LinkedNode<T> tmp, preNode = null;
        tmp = head;
        while (tmp != null && tmp.getData() != data) {
            preNode = tmp;
            tmp = tmp.getNext();
        }
        if (tmp == null) {
            return;
        }
        preNode.setNext(tmp.getNext());
    }

    private void printLinkedList() {
        LinkedNode<T> tmp = head;
        while (tmp != null) {
            System.out.println("This is the linked list node data: " + tmp.getData());
            tmp = tmp.getNext();
        }
    }

    public static void main(String[] args) {
        LinkedListOperation<Integer> linkedInsertion = new LinkedListOperation<>();
        linkedInsertion.append(22);
        linkedInsertion.append(90);


        linkedInsertion.push(30);


        linkedInsertion.insertAfter(linkedInsertion.head.getNext(), 8888);
        linkedInsertion.printLinkedList();

    }

}
