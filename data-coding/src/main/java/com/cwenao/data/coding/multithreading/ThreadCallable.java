/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.data.coding.multithreading;

import java.util.concurrent.Callable;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id ThreadCallable.java, v1.0.0 2021-03-09 13:49 cwenao Exp $$
 */
public class ThreadCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "test the callable thread...";
    }
}
