/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying.linkedlist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * @author cwenao
 * @version $Id LinkedListWithSimple.java, v 0.1 2017-08-05 10:00 cwenao Exp $$
 */
public class LinkedListWithSimple<T extends Comparable> implements Serializable {

    private LinkedNode<T> head;

    private static final Logger LOG = LoggerFactory.getLogger(LinkedListWithSimple.class);

    public static void main(String[] args) {
        LinkedListWithSimple<Integer> linkedListWithSimple = new LinkedListWithSimple<>();
        linkedListWithSimple.head = new LinkedNode<Integer>(1);

        LinkedNode<Integer> sec = new LinkedNode<Integer>(2);
        LinkedNode<Integer> third = new LinkedNode<Integer>(3);

        linkedListWithSimple.head.setNext(sec);

        sec.setNext(third);

        LinkedNode<Integer> testNode = linkedListWithSimple.head;

        while (testNode != null) {
            LOG.info("this is the node data: {} ", testNode.getData());
            testNode = testNode.getNext();
        }

    }

}
