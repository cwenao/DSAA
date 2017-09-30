/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying.stackandqueue;

import java.util.Stack;

/**
 * @author cwenao
 * @version $Id StockSpanByStack.java, v 0.1 2017-09-29 12:50 cwenao Exp $$
 */
public class StockSpanByStack {
    static void calculateSpan(int[] price, int[] result, int n) {

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        result[0] = 1;
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && price[stack.peek()] <= price[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }
    }

    public static void main(String[] args) {
        int[] price = {10, 4, 5, 90, 120, 80};
        int n = price.length;
        int[] result = new int[n];

        calculateSpan(price, result, n);

        for (int x : result) {
            System.out.println(x);
        }
    }
}
