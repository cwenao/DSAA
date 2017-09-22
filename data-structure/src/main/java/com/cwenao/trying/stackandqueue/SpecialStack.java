/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying.stackandqueue;

import java.util.Stack;

/**
 * Design a Data Structure SpecialStack that supports all the stack operations like
 * push(), pop(), isEmpty(), isFull() and an additional operation getMin()
 * which should return minimum element from the SpecialStack.
 * All these operations of SpecialStack must be O(1).
 *
 * @author cwenao
 * @version $Id SpecialStack.java, v 0.1 2017-09-22 08:41 cwenao Exp $$
 */
public class SpecialStack extends Stack<Integer> {

    private Stack<Integer> min = new Stack<>();

    public void push(int x) {
        if (isEmpty() == true) {
            super.push(x);
            min.push(x);
        } else {
            super.push(x);
            int y = min.pop();
            min.push(y);
            if (x <= y) {
                min.push(x);
            }
        }
    }

    public Integer pop() {
        int x = super.pop();
        int y = min.pop();
        if (y != x) {
            min.push(y);
        }
        return x;
    }

    public Integer getMin() {
        int x = min.pop();
        min.push(x);
        return x;
    }

    public static void main(String[] args) {
        SpecialStack specialStack = new SpecialStack();
        specialStack.push(10);
        specialStack.push(20);
        specialStack.push(30);
        System.out.println(specialStack.getMin());
        specialStack.push(5);
        System.out.println(specialStack.getMin());

    }

}
