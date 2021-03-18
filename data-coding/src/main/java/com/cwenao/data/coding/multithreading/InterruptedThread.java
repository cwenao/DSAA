/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.data.coding.multithreading;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id InterruptedThread.java, v1.0.0 2021-03-09 10:52 cwenao Exp $$
 */
public class InterruptedThread {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new MyThread();
        thread.start();
        Thread.sleep(1);
        thread.interrupt();
        thread.join();
        System.out.println("waiting the mythread ending...");
    }


}
