/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.data.coding.multithreading;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id CreatedThread.java, v1.0.0 2021-03-09 09:39 cwenao Exp $$
 */
public class CreatedThread {

    public static void main(String[] args) {
        System.out.println("start the thread --> " + Thread.currentThread().getName());
        //extends Thread
        Thread thread = new MyThread();
        thread.start();

        //implements Runnable
        Thread runnable = new Thread(new MyRunnable());
        runnable.start();


    }
}
