/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying.stackandqueue;

import java.util.Stack;

/**
 * Using two recursion to reverse the stack
 *
 * @author cwenao
 * @version $Id ReverseStackWithRecursion.java, v 0.1 2017-10-05 22:46 cwenao Exp $$
 */
public class ReverseStackWithRecursion {

    private static Stack<Integer> stack = new Stack<>();

    private static void insertAtBottom(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
        } else {
            int a = stack.peek();
            stack.pop();
            insertAtBottom(x);
            stack.push(a);
        }
    }

    public static void reverseStack() {
        if (stack.size()>0) {
            int a = stack.peek();
            stack.pop();
            reverseStack();
            insertAtBottom(a);
        }
    }

    public static void main(String[] args) {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        reverseStack();

        System.out.println(stack);

    }
}
