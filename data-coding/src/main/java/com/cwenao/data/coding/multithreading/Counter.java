/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.data.coding.multithreading;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id Counter.java, v1.0.0 2021-03-09 11:13 cwenao Exp $$
 */
public class Counter {

    private int count = 0;

    public void add(int n) {
        synchronized(this){
            count += n;
        }
    }

    public void dec(int n){
        synchronized (this){
            count -= n;
        }
    }

    public int getCount() {
        return count;
    }
}
