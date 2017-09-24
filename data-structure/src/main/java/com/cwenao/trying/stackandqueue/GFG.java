/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying.stackandqueue;

/**
 * @author cwenao
 * @version $Id GFG.java, v 0.1 2017-09-23 13:31 cwenao Exp $$
 */
public class GFG {
    private class DLLNode {
        DLLNode preNode;
        DLLNode next;
        int data;

        DLLNode(int data) {
            this.data = data;
        }
    }

    private class MyStack {
        DLLNode head;
        DLLNode mid;
        int count;
    }

    public MyStack createMyStack() {
        MyStack myStack = new MyStack();
        myStack.count = 0;
        return myStack;
    }

    public void push(MyStack myStack, int data) {

        DLLNode dllNode = new DLLNode(data);
        dllNode.preNode = null;
        dllNode.next = myStack.head;
        myStack.count += 1;

        if (myStack.count == 1) {
            myStack.mid = dllNode;
        } else {
            myStack.head.preNode = dllNode;
            if (myStack.count % 2 !=0) {
                myStack.mid = myStack.mid.preNode;
            }
        }

        myStack.head = dllNode;
    }

    public int pop(MyStack myStack) {

        if (myStack == null) {
            return -1;
        }

        DLLNode dllNode = myStack.head;
        int data = dllNode.data;
        myStack.head = dllNode.next;

        if (myStack.head !=null) {
            myStack.head.preNode = null;
        }
        myStack.count -= 1;

        if (myStack.count % 2 == 0) {
            myStack.mid = myStack.mid.next;
        }

        return data;

    }

    public int getMid(MyStack myStack) {
        if (myStack.mid == null) {
            return -1;
        }
        return myStack.mid.data;
    }

    public static void main(String[] args) {
        GFG gfg = new GFG();
        MyStack myStack = gfg.createMyStack();
        gfg.push(myStack, 1);
        gfg.push(myStack, 5);
        gfg.push(myStack, 30);
        gfg.push(myStack, 45);

        System.out.println(gfg.getMid(myStack));
        System.out.println(gfg.pop(myStack));

    }

}
