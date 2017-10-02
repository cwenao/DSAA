/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying.stackandqueue;

/**
 * @author cwenao
 * @version $Id NextGreaterElementByStack.java, v 0.1 2017-10-01 08:50 cwenao Exp $$
 */
public class NextGreaterElementByStack {
    static class NGEStack {

        int top;
        int[] items = new int[100];

        void push(int x) {
            if (top >= 99) {
                System.out.println("The stack is full");
            } else {
                items[++top] = x;
            }
        }

        int pop() {
            if (top < 0) {
                System.out.println("The stack is empty");
                return -1;
            } else {
                int x = items[top];
                top--;
                return x;
            }

        }

        boolean isEmpty() {
            return top == -1;
        }
    }

    static void nge(int[] arr) {
        int len = arr.length;
        NGEStack ngeStack = new NGEStack();
        int i = 0;
        ngeStack.top = -1;
        int element, next;

        ngeStack.push(arr[0]);

        for (int x = 1; x < len; x++) {
            next = arr[x];

            if (!ngeStack.isEmpty()) {
                element = ngeStack.pop();

                while (element < next) {
                    System.out.println(element + " --- " + next);
                    if (ngeStack.isEmpty()) {
                        break;
                    }
                    element = ngeStack.pop();
                }
                if (element>next) {
                    ngeStack.push(element);
                }
            }
            ngeStack.push(next);
        }

        while (!ngeStack.isEmpty()) {
            element = ngeStack.pop();
            next = -1;
            System.out.println(element + " --- " + next);
        }
    }

    public static void main(String[] args) {
        int[] arr = {11, 13, 21, 3};
        nge(arr);
    }

}
