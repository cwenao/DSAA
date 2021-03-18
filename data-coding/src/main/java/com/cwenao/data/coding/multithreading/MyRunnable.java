/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.data.coding.multithreading;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id MyRunnable.java, v1.0.0 2021-03-09 10:05 cwenao Exp $$
 */
public class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("start new thread from runnable -----> "+Thread.currentThread().getName());
    }
}
