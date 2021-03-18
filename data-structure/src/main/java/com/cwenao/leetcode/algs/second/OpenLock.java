/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.second;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id OpenLock.java, v1.0.0 2021-03-18 10:45 cwenao Exp $$
 */
public class OpenLock {

    private Map<String, String> deadendsMap = null;

    public int openLock(String[] deadends, String target) {

        deadendsMap = Arrays.stream(deadends)
                .collect(Collectors.toMap(e -> e, e -> e, (eo, en) -> en));

        String start = "0000";

//        int steps = openLockByBFS(target, start);
        int steps = openLockByDoubleBFS(target, start);
        return steps;
    }

    private int openLockByDoubleBFS(String target, String start) {

        Set<String> startSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> tmpSet = null;

        startSet.add(start);
        endSet.add(target);
        int steps = 0;

        while (!startSet.isEmpty() && !endSet.isEmpty()) {
            if (startSet.size() > endSet.size()) {
                tmpSet = startSet;
                startSet = endSet;
                endSet = startSet;
            }
            tmpSet = new HashSet<>();

            for (String t : startSet) {
                if (deadendsMap.containsKey(t)) {
                    continue;
                }
                if (endSet.contains(t)) {
                    return steps;
                }

                for (int i = 0; i < t.length(); i++) {
                    String currentUp = currentPushOne(t, i);
                    if (!deadendsMap.containsKey(currentUp)) {
                        tmpSet.add(currentUp);
                    }

                    String currentDown = currentPullOne(t, i);
                    if (!deadendsMap.containsKey(currentDown)) {
                        tmpSet.add(currentDown);
                    }
                }
            }
            steps++;
        }

        return -1;
    }

    private int openLockByBFS(String target, String start) {

        Map<String, String> existing = new HashMap<>();
        Queue<String> bfsQueue = new LinkedList<>();
        int steps = 0;

        existing.put(start, start);
        bfsQueue.offer(start);

        while (!bfsQueue.isEmpty()) {
            int len = bfsQueue.size();

            for (int i = 0; i < len; i++) {
                String current = bfsQueue.poll();

                if (current.equals(target)) {
                    return steps;
                }
                if (existing.containsKey(current)) {
                    continue;
                }

                for (int j = 0; j < current.length(); j++) {

                    String currentUp = currentPushOne(current, j);
                    offerCurrent(bfsQueue, existing, currentUp);

                    String currentDown = currentPullOne(current, j);
                    offerCurrent(bfsQueue, existing, currentDown);

                }
            }
            steps++;
        }

        return -1;
    }



    private String currentPullOne(String current, int x) {
        char[] currentDown = current.toCharArray();
        int re = ((currentDown[x] - '0') - 1 + 10) % 10;
        currentDown[x] = (char) (re + 48);

        return new String(currentDown);
    }

    private String currentPushOne(String current, int x) {
        char[] currentUp = current.toCharArray();
        int re = ((currentUp[x] - '0') + 1 + 10) % 10;
        currentUp[x] = (char)(re + 48);

        return new String(currentUp);
    }

    private void offerCurrent(Queue<String> bfsQueue, Map<String, String> existing, String current) {
        if (!deadendsMap.containsKey(current) && !existing.containsKey(current)) {
            bfsQueue.offer(current);
            existing.put(current, current);
        }
    }

    public static void main(String[] args) {
        String test = "9099";
        char[] testChar = test.toCharArray();
        System.out.println((testChar[0]-'0'-1+10)%10);
        System.out.println((testChar[1]-'0'+1+10)%10);
    }

}
