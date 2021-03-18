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
 * @version $Id ThreadCachedPoolTest.java, v1.0.0 2021-03-09 18:19 cwenao Exp $$
 */
public class ThreadCachedPoolTest {

    public static void main(String[] args) {
        ExecutorService cached =  Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            cached.submit(new ThreadPoolRunnable("the thread type is cached... " + i));
        }
        cached.shutdown();
    }
}
