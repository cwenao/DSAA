/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

import java.util.Stack;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id RemoveDuplicateLetters.java, v1.0.0 2021-01-09 18:19 cwenao Exp $$
 */
public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        int[] count = new int[256];
        boolean[] inStack = new boolean[256];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }

        for (char c : s.toCharArray()) {
            count[c]--;
            if (inStack[c]) {
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > c) {
                if (count[stack.peek()] == 0) {
                    break;
                }
                inStack[stack.pop()] = false;
            }
            stack.push(c);
            inStack[c] = true;
        }
        StringBuffer stringBuffer = new StringBuffer();

        stack.stream().forEach(ss -> stringBuffer.append(ss));

        return stringBuffer.toString();
    }
}
