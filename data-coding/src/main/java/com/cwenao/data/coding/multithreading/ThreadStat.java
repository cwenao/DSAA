/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.data.coding.multithreading;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id ThreadStat.java, v1.0.0 2021-03-09 10:17 cwenao Exp $$
 */
public class ThreadStat {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("start the thread ... " + Thread.currentThread().getName());
        });
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end the main thread ..." + Thread.currentThread().getName());

    }

}
