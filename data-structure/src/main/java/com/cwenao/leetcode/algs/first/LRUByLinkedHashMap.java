/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

import java.util.LinkedHashMap;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id LRUByLinkedListMap.java, v1.0.0 2021-01-02 10:22 cwenao Exp $$
 */
public class LRUByLinkedHashMap {

    private int capacity;

    private LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

    public LRUByLinkedHashMap(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
            makeRecently(key);
            return;
        }

        if (cache.size() >= capacity) {
            int leastRecentlyKey = cache.keySet().iterator().next();
            cache.remove(leastRecentlyKey);
        }
        cache.put(key, value);
    }

    private void makeRecently(int key) {
        int value = cache.get(key);
        cache.remove(key);
        cache.put(key, value);
    }

    public int capacity() {
        return capacity;
    }

}
