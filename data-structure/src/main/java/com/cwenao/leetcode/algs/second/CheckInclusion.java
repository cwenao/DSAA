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
 * @version $Id CheckInclusion.java, v1.0.0 2021-03-22 18:53 cwenao Exp $$
 */
public class CheckInclusion {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        return checkInclusionByFastAndSlowPoint(s1, s2);
    }

    private boolean checkInclusionByFastAndSlowPoint(String target, String source) {

        Map<Character, Integer> windowMap = new HashMap<>();
        Map<Character, Integer> targetMap = new HashMap<>();

        for (char x : target.toCharArray()) {
            targetMap.put(x, targetMap.containsKey(x) ? targetMap.get(x) + 1 : 1);
        }

        int slow =0,fast =0;
        int validate = 0;
        char[] sources = source.toCharArray();

        while (fast < source.length()) {

            char tmp = sources[fast];
            fast++;

            if (targetMap.containsKey(tmp)) {
                windowMap.put(tmp, windowMap.containsKey(tmp) ? windowMap.get(tmp) + 1 : 1);

                if (targetMap.get(tmp).equals(windowMap.get(tmp))) {
                    validate++;
                }
            }

            while (fast - slow >= target.length()) {
                if (validate == targetMap.size()) {
                    return true;
                }

                char removed = sources[slow];
                slow++;

                if (targetMap.containsKey(removed)) {
                    if (windowMap.containsKey(removed) && windowMap.get(removed).equals(targetMap.get(removed))) {
                        validate--;
                    }
                    windowMap.put(removed, windowMap.get(removed) - 1);
                }
            }

        }
        return false;
    }
}
