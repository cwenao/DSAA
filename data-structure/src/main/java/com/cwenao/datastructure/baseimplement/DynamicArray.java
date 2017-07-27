/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure.baseimplement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author cwenao
 * @version $Id DynamicArray.java, v 0.1 2017-07-09 22:54 cwenao Exp $$
 */
public class DynamicArray {
    private int[] dyArray = null;
    private int[] backupArray = null;
    private int currentIndex = 0;
    private static final int MAX_SIZE = 16;
    private static final int THRESHOLD_VALUE = 2;

    private static final Logger LOG = LoggerFactory.getLogger(DynamicArray.class);

    public DynamicArray() {
        dyArray = new int[0];
    }

    public int size() {
        if (dyArray != null) {
            return dyArray.length;
        } else {
            return 0;
        }
    }

    public void add(int i) {
        if ((dyArray.length - currentIndex) <= THRESHOLD_VALUE) {
            backupArray = dyArray;
            dyArray = new int[(dyArray.length) == 0 ? MAX_SIZE : (dyArray.length * 2)];
            //dyArray = backupArray;
            for(int x=0;x<backupArray.length;x++) {
                dyArray[x] = backupArray[x];
            }
            backupArray = null;
        }
        dyArray[currentIndex] = i;
        currentIndex++;
    }

    public int get(int i) {
        return dyArray[i];
    }

    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.add(1);
        LOG.info("this is the dynamic size: {}",dynamicArray.size());
        LOG.info("this is the x to dynamic array : {}", dynamicArray.get(0));

    }
}

