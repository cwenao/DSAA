/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

import com.cwenao.leetcode.algs.first.DoubleList.Node;
import java.util.HashMap;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id LRUByDefinedDoubleList.java, v1.0.0 2021-01-02 10:09 cwenao Exp $$
 */
public class LRUByDefinedDoubleList {

    private HashMap<Integer, Node> map;

    private DoubleList cache;

    private int capacity;

    LRUByDefinedDoubleList(int capacity) {
        map = new HashMap<>();
        cache = new DoubleList();
        this.capacity = capacity;
    }

    public void addRecently(int key, int value) {
        DoubleList.Node node = (new DoubleList()).new Node(key, value);
        cache.addLast(node);
        map.put(key, node);
    }

    public void removeByKey(int key) {
        Node node = map.get(key);
        cache.remove(node);
        map.remove(key);
    }

    public void makeRecently(int key) {
        Node node = map.get(key);
        cache.remove(node);
        cache.addLast(node);
    }

    public void removeLeastRecently() {
        Node leastRecentlyNode = cache.removeFirst();
        map.remove(leastRecentlyNode.key);
    }

}
