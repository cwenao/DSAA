/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.second;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id FindAnagrams.java, v1.0.0 2021-03-22 19:15 cwenao Exp $$
 */
public class FindAnagrams {

    public List<Integer> findAnagrams(String s, String p) {

        return findAnagramsByFastAndSlowPoint(s, p);
    }

    private List<Integer> findAnagramsByFastAndSlowPoint(String source, String target) {

        Map<Character, Integer> windowMap = new HashMap<>();
        Map<Character, Integer> targetMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        char[] sources = source.toCharArray();

        for (char x : target.toCharArray()) {
            targetMap.put(x, targetMap.containsKey(x) ? targetMap.get(x) + 1 : 1);
        }

        int fast = 0, slow = 0;
        int validate = 0;

        while (fast < target.length()) {
            char tmp = sources[fast];
            fast++;

            if (targetMap.containsKey(tmp)) {
                windowMap.put(tmp, windowMap.containsKey(tmp) ? windowMap.get(tmp) + 1 : 1);
                if (windowMap.get(tmp).equals(targetMap.get(tmp))) {
                    validate++;
                }
            }

            while (fast - slow > target.length()) {
                if (validate == targetMap.size()) {
                    result.add(slow);
                }

                char removed = sources[slow];
                slow++;

                if (targetMap.containsKey(removed)) {
                    if (windowMap.get(removed).equals(targetMap.get(removed))) {
                        validate--;
                    }
                    windowMap.put(removed, windowMap.get(removed) - 1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        com.cwenao.leetcode.algs.first.FindAnagrams findAnagrams = new com.cwenao.leetcode.algs.first.FindAnagrams();
        List<Integer> result = findAnagrams.findAnagrams(s, p);
        for (Integer i : result) {
            System.out.println(i);
        }
    }
}
