/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure.baseimplement;

import java.util.NoSuchElementException;

/**
 * @author cwenao
 * @version $Id QueueWithFixedSizeArray.java, v 0.1 2017-07-12 8:06 cwenao Exp $$
 */
public class QueueWithFixedSizeArray<E> {

    private E[] queue = null;
    private int maxSize = 30;
    private int currentIndex;

    public QueueWithFixedSizeArray() {
        queue = (E[]) new Object[30];
        currentIndex = 0;
    }

    public QueueWithFixedSizeArray(int capacity) {
        queue = (E[]) new Object[capacity];
        currentIndex = 0;
        maxSize = capacity;
    }

    public E enqueue(E value) {
        if (currentIndex >= maxSize) {
            throw new NoSuchElementException(" The queue is full");
        }
        queue[currentIndex] = value;
        if (currentIndex < maxSize-1) {
            currentIndex++;
        }
        return value;
    }

    public E dequeue() {
        if (currentIndex == 0) {
            throw new NoSuchElementException(" The queue is empty");
        }

        E tmp = queue[0];
        for(int i = 0; i<currentIndex; i++) {
            queue[i] = queue[i + 1];
        }
        if (currentIndex < maxSize -1) {
            queue[currentIndex] = queue[currentIndex + 1];
        }

        currentIndex--;

        return tmp;
    }

    public static void main(String[] args) {
        QueueWithFixedSizeArray<Integer> queueWithFixedSizeArray = new QueueWithFixedSizeArray(5);
        queueWithFixedSizeArray.enqueue(5);
        queueWithFixedSizeArray.enqueue(10);
        queueWithFixedSizeArray.enqueue(50);
        queueWithFixedSizeArray.enqueue(100);
        queueWithFixedSizeArray.enqueue(25);

        System.out.println(queueWithFixedSizeArray.dequeue());
        System.out.println(queueWithFixedSizeArray.dequeue());

    }

}

