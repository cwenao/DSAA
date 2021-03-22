/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.second;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id MinWindow.java, v1.0.0 2021-03-19 15:02 cwenao Exp $$
 */
public class MinWindow {

    public String minWindow(String s, String t) {
        if (s.equals(t)) {
            return s;
        }

        return minWindowBySlowFastPoint(s, t);
    }

    private String minWindowBySlowFastPoint(String s, String t) {

        char[] source = s.toCharArray();
        char[] target = t.toCharArray();

        Map<Character, Integer> targetMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();

        for (char c : target) {
            targetMap.put(c, targetMap.containsKey(c) ? targetMap.get(c) + 1 : 1);
        }
        //target -> targetMap
        //定义validate用于判断子串中是否符合target
        int slow = 0, fast = 0;
        int validate=0;
        int start = 0, len = Integer.MAX_VALUE;

        while (fast < source.length) {

            char tmp = source[fast];
            fast++;

            if (targetMap.containsKey(tmp)) {
                windowMap.put(tmp,windowMap.containsKey(tmp)? windowMap.get(tmp) + 1 : 1 );
                if (windowMap.get(tmp).equals(targetMap.get(tmp))) {
                    validate++;
                }
            }

            while (validate == target.length) {
                if (fast - slow < len) {
                    start = slow;
                    len = fast - slow;
                }
                char remove = source[slow];
                slow++;
                if (targetMap.containsKey(remove)) {
                    if (windowMap.containsKey(remove) && windowMap.get(remove).equals(targetMap.get(remove))) {
                        validate--;
                    }
                    windowMap.put(remove, windowMap.get(remove) - 1);
                }
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {

        String s = "ADOBECODEBANC", t = "ABC";

        MinWindow minWindow = new MinWindow();
        System.out.println(minWindow.minWindow(s, t));
    }
}
