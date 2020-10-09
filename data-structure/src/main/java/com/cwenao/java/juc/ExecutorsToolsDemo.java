/**
 * Company Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.java.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * TODO : Statement the class description
 * @author cwenao
 * @version $Id ExecutorsToolsDemo.java, v1.0.0 2020-07-21 13:33 cwenao Exp $$
 */
public class ExecutorsToolsDemo {

    private static final int taskSize = 2;

    public void poolsTest() throws ExecutionException, InterruptedException {

        ExecutorService pool = Executors.newFixedThreadPool(taskSize);

        List<Future> futureList = new ArrayList<>();

        for (int i = 0; i < taskSize; i++) {
            Callable callable = new MyCallable(i + " "+pool.toString());
            Future future = pool.submit(callable);

            futureList.add(future);
        }

        pool.shutdown();

        for (Future future : futureList) {
            System.out.println("res: "+future.get().toString());
        }

    }

    public void poolsTest2() {
        ExecutorService threadPool = Executors.newFixedThreadPool(taskSize);
        while (true) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("res: "+Thread.currentThread().getName()+" is running...");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    class  MyCallable implements Callable {

        private String condition;

        MyCallable(String condition) {
            this.condition = condition;
        }


        @Override
        public Object  call() throws Exception {
            return condition;
        }
    }

    public static void main(String[] args) {
        ExecutorsToolsDemo executorsToolsDemo = new ExecutorsToolsDemo();

        //callable
        try {
            executorsToolsDemo.poolsTest();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //thread pools

        executorsToolsDemo.poolsTest2();
    }



}
