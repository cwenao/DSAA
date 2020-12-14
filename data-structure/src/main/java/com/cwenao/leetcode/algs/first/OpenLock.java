/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id OpenLock.java, v1.0.0 2020-12-13 08:18 cwenao Exp $$
 */
public class OpenLock {

    public int openLock(String[] deadends, String target) {

        Map<String, String> deadendMap = new HashMap<>(deadends.length);
        String start = "0000";

        for (String deadend : deadends) {
            if (!deadendMap.containsKey(deadend)) {
                deadendMap.put(deadend, deadend);
            }
        }

//        return openLockByBFS(deadendMap, target,start);
        return openLockByDoubleBFS(deadendMap, target,start);
    }

    private int openLockByDoubleBFS(Map<String, String> deadendMap, String target,String start) {

        int steps = 0;
        Set<String> queueStart = new HashSet<>();
        Set<String> queueEnd = new HashSet<>();

        queueStart.add(start);
        queueEnd.add(target);

        Set<String> tmpQueue = null;
        while (!queueStart.isEmpty() && !queueEnd.isEmpty()) {

            if (queueStart.size() > queueEnd.size()) {
                tmpQueue = queueStart;
                queueStart = queueEnd;
                queueEnd = tmpQueue;
            }

            tmpQueue = new HashSet<>();

            for (String startKey : queueStart) {

                if (deadendMap.containsKey(startKey)) {
                    continue;
                }
                if (queueEnd.contains(startKey)) {
                    return steps;
                }

                for (int x = 0; x < startKey.length(); x++) {
                    String currentUp = currentPushOne(startKey, x);
                    if (!deadendMap.containsKey(currentUp) ) {
                        tmpQueue.add(currentUp);
                    }

                    String currentDown = currentPullOne(startKey, x);
                    if (!deadendMap.containsKey(currentDown) ) {
                        tmpQueue.add(currentDown);
                    }
                }
            }
            steps++;
            queueStart = tmpQueue;
        }
        return -1;
    }

    private int openLockByBFS(Map<String, String> deadendMap, String target,String start) {

        int steps = 0;
        Queue<String> queue = new LinkedList<>();
        Map<String, String> existing = new HashMap<>();
        queue.offer(start);
        existing.put(start, start);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(target)) {
                    return steps;
                }
                if (deadendMap.containsKey(current)) {
                    continue;
                }

                for (int x = 0; x < current.length(); x++) {
                    String currentUp = currentPushOne(current, x);
                    if (!deadendMap.containsKey(currentUp) && !existing.containsKey(currentUp)) {
                        existing.put(currentUp, current);
                        queue.offer(currentUp);
                    }

                    String currentDown = currentPullOne(current, x);
                    if (!deadendMap.containsKey(currentDown) && !existing
                            .containsKey(currentDown)) {
                        existing.put(currentDown, currentDown);
                        queue.offer(currentDown);
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    private String currentPullOne(String current, int x) {

        char[] currentDown = current.toCharArray();
        int re = ((currentDown[x] - '0') +  1 + 10) % 10;
        currentDown[x] = (char) (re + 48);

        return new String(currentDown);
    }

    private String currentPushOne(String current, int x) {

        char[] currentUp = current.toCharArray();

        int re = ((currentUp[x] - '0') -1 + 10) % 10;
        currentUp[x] = (char) (re + 48);

        return new String(currentUp);
    }

    public static void main(String[] args) {
        OpenLock openLock = new OpenLock();

        String[] deadends = new String[]{"0201","0101","0102","1212","2002"};
        String target = "0202";

        System.out.println(openLock.openLock(deadends, target));


    }

}
