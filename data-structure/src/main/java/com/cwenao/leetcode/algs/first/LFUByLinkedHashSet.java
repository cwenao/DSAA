/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id LFUByLinkedHashSet.java, v1.0.0 2021-01-02 10:57 cwenao Exp $$
 */
public class LFUByLinkedHashSet {

    private int capacity;

    private int minFrequency;

    //key - value 映射
    private HashMap<Integer, Integer> keyToValue;

    //key - frequency 映射
    private HashMap<Integer, Integer> keyToFreq;

    //frequency - keys列表映射
    private HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;

    public LFUByLinkedHashSet(int capacity) {
        this.capacity = capacity;
        this.minFrequency = 0;
        keyToValue = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
    }

    public int get(int key) {
        if (!keyToValue.containsKey(key)) {
            return -1;
        }
        increaseFreq(key);
        return keyToValue.get(key);
    }


    public void put(int key, int value) {

        if (keyToValue.containsKey(key)) {
            keyToValue.put(key, value);
            increaseFreq(key);
            return;
        }

        if (keyToValue.size() >= this.capacity) {
            removeMinCapacity();
        }

        keyToValue.put(key, value);
        keyToFreq.put(key, 1);
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        this.minFrequency = 1;
    }

    private void removeMinCapacity() {
        LinkedHashSet<Integer> linkedHashSet = freqToKeys.get(this.minFrequency);
        int firstKey = linkedHashSet.iterator().next();

        linkedHashSet.remove(firstKey);
        if (linkedHashSet.isEmpty()) {
            freqToKeys.remove(this.minFrequency);
        }

        keyToValue.remove(firstKey);
        keyToFreq.remove(firstKey);
    }


    private void increaseFreq(int key) {
        int frequency = keyToFreq.get(key);
        keyToFreq.put(key, frequency + 1);

        freqToKeys.get(frequency).remove(key);
        freqToKeys.putIfAbsent(frequency + 1, new LinkedHashSet<>());
        freqToKeys.get(frequency + 1).add(key);

        if (freqToKeys.get(frequency).isEmpty()) {
            freqToKeys.remove(frequency);
            if (frequency == minFrequency) {
                minFrequency++;
            }
        }

    }

}
