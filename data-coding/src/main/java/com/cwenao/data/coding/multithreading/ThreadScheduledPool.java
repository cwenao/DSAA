/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.data.coding.multithreading;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id ThreadScheduledPool.java, v1.0.0 2021-03-09 18:37 cwenao Exp $$
 */
public class ThreadScheduledPool {

    public static void main(String[] args) {
        ScheduledExecutorService schedule = Executors.newScheduledThreadPool(4);

        //只执行一次
        schedule.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("schedule -> 当前时间："+ (new Date()).toString());
            }
        },3, TimeUnit.SECONDS);

        //scheduleAtFixedRate 2秒后 按固定时间3秒执行
        schedule.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("scheduleAtFixedRate ->当前时间：" + (new Date()).toString());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 2,1, TimeUnit.SECONDS);

        //scheduleWithFixedDelay 2秒后开始执行定时任务，以3秒为间隔执行

        schedule.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println("scheduleWithFixedDelay ->当前时间：" + (new Date()).toString());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 2, 3, TimeUnit.SECONDS);

    }

}
