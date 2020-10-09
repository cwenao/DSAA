/**
 * Company Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.java.juc;

/**
 *
 * TODO : Statement the class description
 * @author cwenao
 * @version $Id SimpleRunnableDemo.java, v1.0.0 2020-07-21 13:15 cwenao Exp $$
 */
public class SimpleRunnableDemo implements Runnable{

    @Override
    public void run() {
        System.out.println("the current thread id is: "+Thread.currentThread().getId());
    }

    public static void main(String[] args) {
        SimpleRunnableDemo simpleRunnableDemo = new SimpleRunnableDemo();
        Thread thread = new Thread(simpleRunnableDemo);
        thread.start();
    }

}
