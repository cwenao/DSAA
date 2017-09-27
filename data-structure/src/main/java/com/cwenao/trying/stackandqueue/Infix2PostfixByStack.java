/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying.stackandqueue;

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


}
