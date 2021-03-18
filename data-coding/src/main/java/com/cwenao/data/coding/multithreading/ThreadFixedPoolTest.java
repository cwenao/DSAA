/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.data.coding.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id ThreadPoolTest.java, v1.0.0 2021-03-09 13:37 cwenao Exp $$
 */
public class ThreadFixedPoolTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 10; i++) {
            executorService.submit(new ThreadPoolRunnable("executor's name ----> " + i));
        }
        executorService.shutdown();
    }

}
