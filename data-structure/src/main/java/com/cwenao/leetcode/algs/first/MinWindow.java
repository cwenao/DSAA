/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.lang.StringUtils;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id MinWindow.java, v1.0.0 2020-12-13 15:35 cwenao Exp $$
 */
public class MinWindow {

    public String minWindow(String s, String t) {

        if (s.equals(t)) {
            return s;
        }

        return minStringByFastAndSlowPoint(s, t);
    }

    private String minStringByFastAndSlowPoint(String s, String t) {

        char[] source = s.toCharArray();

        Map<Character, Integer> target = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        char[] targetTmp = t.toCharArray();

        for (char x : targetTmp) {
            target.put(x, target.containsKey(x) ? target.get(x).intValue() + 1 : 1);
        }

        int fast = 0, slow = 0;
        int valid = 0;
        int start = 0, len = Integer.MAX_VALUE;
        while (fast < source.length) {
            char tmp = source[fast];
            fast++;

            if (target.containsKey(tmp)) {
                window.put(tmp, window.containsKey(tmp) ? window.get(tmp).intValue() + 1 : 1);
                if (window.containsKey(tmp) && window.get(tmp).equals(target.get(tmp))) {
                    valid++;
                }
            }

            while (valid == target.size()) {
                if (fast - slow < len) {
                    start = slow;
                    len = fast - slow;
                }
                char removeTmp = source[slow];
                slow++;

                if (target.containsKey(removeTmp)) {
                    if (window.containsKey(removeTmp) && window.get(removeTmp)
                            .equals(target.get(removeTmp))) {
                        valid--;
                    }
                    window.put(removeTmp, window.get(removeTmp).intValue() - 1);
                }
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, len + start);
    }

    public static void main(String[] args) {
        MinWindow minWindow = new MinWindow();
        String s = "bba", t = "ba";

        System.out.println(minWindow.minWindow(s, t));

    }

}
