/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.data.coding.multithreading;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id ThreadPoolRunnable.java, v1.0.0 2021-03-09 13:34 cwenao Exp $$
 */
public class ThreadPoolRunnable implements Runnable{

    private final String name;

    public ThreadPoolRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("start print thread's name : " +Thread.currentThread().getId()+" "+ name);
        try {
            Thread.sleep(10);
            //newSingleThreadExecutor
//            if ("single...4".equals(name)) {
//                throw new RuntimeException();
//            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("多线程错误：" + Thread.currentThread().getId());
        }
        System.out.println("end print thread's name : " +Thread.currentThread().getId() +" "+ name);
    }
}
