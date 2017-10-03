/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying.stackandqueue;

import java.util.Stack;

/**
 *
 * @author cwenao
 * @version $Id CelebrityProblemByStack.java, v 0.1 2017-10-03 12:59 cwenao Exp $$
 */
public class CelebrityProblemByStack {

    private static final int[][] MARKED = {{0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}, {0, 0, 1, 0}};

    private boolean isKnown(int a, int b) {
        return MARKED[a][b] == 1;
    }

    public int findCelebrity(int n) {
        Stack<Integer> stack = new Stack<>();
        int c;

        for (int i = 0; i < n; i++) {
            stack.push(i);
        }
        while (!stack.isEmpty() && stack.size() > 1) {

            int a = stack.pop();
            int b = stack.pop();
            if (isKnown(a, b)) {
                stack.push(b);
            } else {
                stack.push(a);
            }
        }
        c = stack.pop();

        for (int i = 0; i < n; i++) {

        }

    }

}
