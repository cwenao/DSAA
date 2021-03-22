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
 * @version $Id LengthOfLongestSubstring.java, v1.0.0 2021-03-22 19:43 cwenao Exp $$
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        return lengthOfLongestSubstringByFastAndSlowPoint(s);
    }

    private int lengthOfLongestSubstringByFastAndSlowPoint(String s) {

        Map<Character, Integer> windowMap = new HashMap<>();
        char[] sources = s.toCharArray();

        int fast = 0, slow = 0;
        int result = 0;

        while (fast < s.length()) {
            char tmp = sources[fast];
            fast++;

            windowMap.put(tmp, windowMap.containsKey(tmp) ? windowMap.get(tmp) + 1 : 1);
            while (windowMap.get(tmp) > 1) {
                char removed = sources[slow];
                slow++;

                windowMap.put(removed, windowMap.get(removed) - 1);
            }
            result = Math.max(result, fast - slow);
        }

        return result;
    }
}
