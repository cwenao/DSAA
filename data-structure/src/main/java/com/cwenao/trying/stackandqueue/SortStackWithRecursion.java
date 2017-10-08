/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying.stackandqueue;

import java.util.Stack;

/**
 * using two recursion to sort the stack, the method like reverse stack
 * @author cwenao
 * @version $Id SortStackWithRecursion.java, v 0.1 2017-10-07 23:55 cwenao Exp $$
 */
public class SortStackWithRecursion {


    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int x = stack.pop();
            sortStack(stack);
            sortedInsert(stack, x);
        }
    }

    private static void sortedInsert(Stack<Integer> stack, int x) {

        if (stack.isEmpty() || x > stack.peek()) {
            stack.push(x);
            return;
        }
        int tmp = stack.peek();
        stack.pop();
        sortedInsert(stack, x);
        stack.push(tmp);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(30);
        stack.push(20);
        stack.push(5);
        stack.push(100);
        stack.push(120);
        stack.push(-1);
        System.out.print("before Sorting: ");
        System.out.println(stack);

        sortStack(stack);

        System.out.print("after Sorted: ");
        System.out.println(stack);


    }

}
