/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id CheckInclusion.java, v1.0.0 2020-12-13 22:41 cwenao Exp $$
 */
public class CheckInclusion {

    public boolean checkInclusion(String s1, String s2) {
        return checkInclusionByFastAndSlowPoint(s1, s2);
    }

    private boolean checkInclusionByFastAndSlowPoint(String t, String s) {

        Map<Character, Integer> windowMap = new HashMap<>();
        Map<Character, Integer> targetMap = new HashMap<>();

        char[] sources = s.toCharArray();
        char[] targets = t.toCharArray();

        for (char x : targets) {
            targetMap.put(x, targetMap.containsKey(x) ? targetMap.get(x).intValue() + 1 : 1);
        }

        int fast = 0, slow = 0;
        int valid = 0;

        while (fast < sources.length) {
            char tmp = sources[fast];
            fast++;

            if (targetMap.containsKey(tmp)) {
                windowMap.put(tmp,
                        windowMap.containsKey(tmp) ? windowMap.get(tmp).intValue() + 1 : 1);
                if (windowMap.get(tmp).equals(targetMap.get(tmp))) {
                    valid++;
                }
            }

            while (fast - slow >= t.length()) {
                if (valid == targetMap.size()) {
                    return true;
                }
                char removed = sources[slow];
                slow++;

                if (targetMap.containsKey(removed)) {
                    if (windowMap.get(removed).equals(targetMap.get(removed))) {
                        valid--;
                    }
                    windowMap.put(removed, windowMap.get(removed).intValue() - 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidboaoo";
        CheckInclusion checkInclusion = new CheckInclusion();
        System.out.println(checkInclusion.checkInclusion(s1,s2));
    }
}
