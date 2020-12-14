/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id FindAnagrams.java, v1.0.0 2020-12-13 23:14 cwenao Exp $$
 */
public class FindAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        return findAnagramsByFastAndSlowPoint(s, p);
    }

    private List<Integer> findAnagramsByFastAndSlowPoint(String s, String p) {

        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> target = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        char[] sources = s.toCharArray();
        char[] targets = p.toCharArray();

        for (char x : targets) {
            target.put(x, target.containsKey(x) ? target.get(x).intValue() + 1 : 1);
        }

        int fast = 0, slow = 0;
        int valid = 0;

        while (fast < s.length()) {
            char tmp = sources[fast];
            fast++;

            if (target.containsKey(tmp)) {
                window.put(tmp, window.containsKey(tmp) ? window.get(tmp).intValue() + 1 : 1);
                if (window.get(tmp).equals(target.get(tmp))) {
                    valid++;
                }
            }

            while (fast - slow >= p.length()) {

                if (valid == target.size()) {
                    result.add(slow);
                }

                char removed = sources[slow];
                slow++;

                if (target.containsKey(removed)) {
                    if (target.get(removed).equals(window.get(removed))) {
                        valid--;
                    }
                    window.put(removed, window.get(removed).intValue() - 1);
                }

            }

        }
        return result;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        FindAnagrams findAnagrams = new FindAnagrams();
        List<Integer> result = findAnagrams.findAnagrams(s, p);
        for (Integer i : result) {
            System.out.println(i);
        }
    }
}
