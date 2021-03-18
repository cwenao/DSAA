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
 * @version $Id ThreadSingleExectorTest.java, v1.0.0 2021-03-09 18:23 cwenao Exp $$
 */
public class ThreadSingleExecutorTest {

    public static void main(String[] args) {

        ExecutorService singleExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            singleExecutor.submit(new ThreadPoolRunnable("single..." + i));
        }
        singleExecutor.shutdown();

    }

}
