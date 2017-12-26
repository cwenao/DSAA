/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying.stackandqueue;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @author cwenao
 * @version $Id LRUCacheImplementWithQuery.java, v 0.1 2017-11-25 08:43 cwenao Exp $$
 * Queue which is implemented using a doubly linked list.
 * The maximum size of the queue will be equal to the total number of frames available (cache size).
 * The most recently used pages will be near front end and least recently pages will be near rear end.
 */
public class LRUCacheImplementWithQuery {
    private ConcurrentLinkedDeque deque = new ConcurrentLinkedDeque();

    public void refer(String used) {

        if (!deque.contains(used)) {
            deque.addFirst(used);
        } else {
            deque.remove(used);
            deque.addFirst(used);
        }

    }

    public static void main(String[] args) {
        LRUCacheImplementWithQuery lruCacheImplementWithQuery = new LRUCacheImplementWithQuery();
        lruCacheImplementWithQuery.refer("1");
        lruCacheImplementWithQuery.refer("3");
        lruCacheImplementWithQuery.refer("4");
        lruCacheImplementWithQuery.refer("5");
        lruCacheImplementWithQuery.refer("6");
        lruCacheImplementWithQuery.refer("1");

        for (Object test : lruCacheImplementWithQuery.deque.toArray()) {
            System.out.println(test);
        }
    }


}
