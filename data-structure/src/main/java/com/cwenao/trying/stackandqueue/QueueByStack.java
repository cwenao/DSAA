/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying.stackandqueue;

import java.util.Stack;

/**
 * FIFO(First in , first out)
 * @author cwenao
 * @version $Id QueueByStack.java, v 0.1 2017-09-21 01:02 cwenao Exp $$
 */
public class QueueByStack {
    static class Queue {
        Stack<Integer> stack;
    }

    static void push(Stack<Integer> top_ref, int data) {
        top_ref.push(data);
    }

    static int pop(Stack<Integer> top_ref) {
        if (top_ref==null) {
            throw new IllegalArgumentException("the stack is must not null");
        }
        return top_ref.pop();
    }

    /**
     * add the element in rear
     * @param queue
     * @param x
     */
    static void enQueue(Queue queue, int x) {
        push(queue.stack, x);
    }

    /**
     * pop the element in front
     * @param queue
     * @return
     */
    static int deQueue(Queue queue) {
        int x, res = 0;

        if (queue.stack.isEmpty()) {
            System.exit(0);
        } else if (queue.stack.size() == 1) {
            return pop(queue.stack);
        } else {
            x = pop(queue.stack);
            res = deQueue(queue);
            push(queue.stack, x);
            return res;
        }
        return 0;
    }

}
