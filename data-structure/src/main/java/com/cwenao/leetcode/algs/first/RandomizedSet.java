/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id RandomizedSet.java, v1.0.0 2021-01-08 09:00 cwenao Exp $$
 */
public class RandomizedSet {

    private List<Integer> list = new ArrayList<>();

    private Map<Integer, Integer> keyValue = new HashMap<>();

    Random rand = new Random();


    /** Initialize your data structure here. */
    public RandomizedSet() {

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (keyValue.containsKey(val)) {
            return false;
        }

        list.add(list.size(),val);
        keyValue.put(val, list.size() - 1);

        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!keyValue.containsKey(val)) {
            return false;
        }

        int index = keyValue.get(val);
        int tmp = list.get(list.size() - 1);
        list.set(index, tmp);
        list.remove(list.size() - 1);
        keyValue.put(tmp, index);
        keyValue.remove(val);

        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }

}
