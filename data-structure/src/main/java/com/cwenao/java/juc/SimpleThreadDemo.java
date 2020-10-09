/**
 * Company Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.java.juc;

/**
 *
 * TODO : Statement the class description
 * @author cwenao
 * @version $Id SimoleThreadTest.java, v1.0.0 2020-07-21 13:11 cwenao Exp $$
 */
public class SimpleThreadDemo extends Thread {

    public void run(){
        System.out.println("the thread id is: "+Thread.currentThread().getId());
    }


    public static void main(String[] args) {
        SimpleThreadDemo simpleThreadDemo = new SimpleThreadDemo();
        simpleThreadDemo.start();

        SimpleThreadDemo simpleThreadDemo1 = new SimpleThreadDemo();
        simpleThreadDemo1.start();
    }

}
