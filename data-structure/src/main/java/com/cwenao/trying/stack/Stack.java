/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying.stack;

/**
 * @author cwenao
 * @version $Id Stack.java, v 0.1 2017-09-20 13:03 cwenao Exp $$
 */
public class Stack {
    private static final int MAX = 1000;
    int top;
    int[] stack = new int[MAX];

    public boolean isEmpty() {
        return top < 0;
    }

    public Stack() {
        top = -1;
    }

    public boolean push(int x) {
        if (top>=MAX) {
            return false;
        }
        stack[++top] = x;
        return true;
    }

    public int pop() {
        if (top < 0) {
            return 0;
        }
        int x = stack[top--];
        return x;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.pop());
    }

}
