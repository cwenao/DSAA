/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure.baseimplement;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cwenao
 * @version $Id StackWithArrayList.java, v 0.1 2017-07-11 5:56 cwenao Exp $$
 */
public class StackWithArrayList<E> {

    private List<E> stack = null;

    public StackWithArrayList(){
        stack = new ArrayList<>();
    }

    public void push(E e) {
        stack.add(e);
    }

    public E pop() {
        if (stack.size() > 0) {
            return stack.remove(stack.size() - 1);
        }
        return null;
    }

    public int size() {
        return stack.size();
    }

    public static void main(String[] args) {
        StackWithArrayList<Integer> stackWithArrayList = new StackWithArrayList<>();
        stackWithArrayList.push(1);
        stackWithArrayList.push(2);
        System.out.println(stackWithArrayList.size());
        System.out.println(stackWithArrayList.pop());
    }

}

