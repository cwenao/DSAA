/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.data.coding.multithreading;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id MyThread.java, v1.0.0 2021-03-09 10:04 cwenao Exp $$
 */
public class MyThread extends Thread{

    @Override
    public void run() {
        int x = 0;
        while (!isInterrupted()) {
            System.out.println(" start new thread -----> "+x+" "+Thread.currentThread().getName());
            x++;
        }
    }
}
