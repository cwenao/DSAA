/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * implement by Queue queue = new LinkedList();
 * @author cwenao
 * @version $Id StackByQueue.java, v 0.1 2017-09-24 14:56 cwenao Exp $$
 */
public class StackByQueue {

    private Queue<Integer> queue = new LinkedList<>();

    public void push(int x) {
        queue.add(x);

        for (int i = 0; i < queue.size(); i++) {
            int y = queue.remove();
            queue.add(y);
        }
    }

    public int pop() {
        if (queue.isEmpty()) {
            return -1;
        }
        int x = queue.remove();
        return x;
    }

    public int top() {
        return queue.peek();
    }

    public static void main(String[] args) {
        StackByQueue stackByQueue = new StackByQueue();
        stackByQueue.push(1);
        stackByQueue.push(30);
        stackByQueue.push(25);
        System.out.println(stackByQueue.top());
        System.out.println(stackByQueue.pop());
    }
}
