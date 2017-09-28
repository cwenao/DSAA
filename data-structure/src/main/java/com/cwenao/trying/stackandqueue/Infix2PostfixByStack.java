/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying.stackandqueue;

import java.util.Stack;

/**
 * @author cwenao
 * @version $Id Infix2PostfixByStack.java, v 0.1 2017-09-27 16:06 cwenao Exp $$
 */
public class Infix2PostfixByStack {
    static int prec(char operation) {
        switch (operation) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    public static String infix2Postfix(String exp) {
        StringBuffer sb = new StringBuffer();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sb.append(ch);
            } else if ('(' == ch) {
                stack.push(ch);
            } else if (')' == ch) {
                while (!stack.isEmpty() && '(' != stack.peek()) {
                    sb.append(stack.pop());
                }
                if (!stack.isEmpty() && '(' != stack.peek()) {
                    return "Invalid exp";
                } else {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && prec(ch) <= prec(stack.peek())) {
                    sb.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infix2Postfix(exp));
    }
}
