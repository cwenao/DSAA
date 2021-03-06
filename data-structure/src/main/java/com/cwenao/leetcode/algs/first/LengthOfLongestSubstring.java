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
 * @version $Id LengthOfLongestSubstring.java, v1.0.0 2020-12-14 06:24 cwenao Exp $$
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {

        return lengthOfLongestSubstringByWindow(s);

    }

    private int lengthOfLongestSubstringByWindow(String s) {

        Map<Character, Integer> window = new HashMap<>();

        char[] sources = s.toCharArray();

        int fast = 0, slow = 0;
        int result = 0;

        while (fast < s.length()) {
            char tmp = sources[fast];
            fast++;

            window.put(tmp, window.containsKey(tmp) ? window.get(tmp) + 1 : 1);

            while (window.get(tmp) > 1) {
                char removed = sources[slow];
                slow++;
                window.put(removed, window.get(removed) - 1);
            }

            result = Math.max(result, fast - slow);
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring(s));
    }

}
