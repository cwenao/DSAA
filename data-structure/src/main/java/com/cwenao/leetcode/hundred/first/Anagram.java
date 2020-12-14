/**
 * Company Copyright (C) 2014-2019 All Rights Reserved.
 */
package com.cwenao.leetcode.hundred.first;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * #242. 有效的字母异位词
 * @author cwenao
 * @version $Id Anagram.java, v1.0.0 2019-08-21 16:15 cwenao Exp $$
 */
public class Anagram {

    public boolean isAnagram(String s, String t) {


        if (s.length() != t.length()) {
            return false;
        }

        char source[] = s.toCharArray();
        char target[] = t.toCharArray();


        Map<String, Integer> hash = new HashMap<>();

        for (int x = 0; x < source.length; x++) {

            String sKey = String.valueOf(source[x]);
            String tKey = String.valueOf(target[x]);

            hash.put(sKey, hash.containsKey(sKey) ? (hash.get(sKey).intValue() + 1) : 1);
            hash.put(tKey, hash.containsKey(tKey) ? (hash.get(tKey).intValue() - 1) : -1);
        }

        for (Map.Entry<String, Integer> entry : hash.entrySet()) {
            if (entry.getValue().intValue() != 0) {
                return false;
            }
        }

        return true;
    }

    public boolean isAnagram2(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        char source[] = s.toCharArray();
        char target[] = t.toCharArray();

        Arrays.sort(source);
        Arrays.sort(target);


        return Arrays.equals(source,target);
    }

        public static void main(String[] args) {
        Anagram anagram = new Anagram();

        System.out.println(anagram.isAnagram("ab","bc"));

    }

}
