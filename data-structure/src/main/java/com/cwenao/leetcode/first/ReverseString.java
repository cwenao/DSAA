/**
 * Company Copyright (C) 2014-2019 All Rights Reserved.
 */
package com.cwenao.leetcode.first;

import java.util.Arrays;

/**
 *
 * TODO : Statement the class description
 * @author cwenao
 * @version $Id ReverseString.java, v1.0.0 2019-07-02 08:39 cwenao Exp $$
 */
public class ReverseString {

    public static void reverseString(char s[]) {

        int len = s.length;
        int mid = len/2;
        int high = mid;
        if (len % 2 != 0) {
            high += 1;
        }
        for (int low = mid-1; low >= 0; low--) {
            char tmp = s[low];
            s[low] = s[high];
            s[high] = tmp;
            high++;
        }

    }

    public static void main(String[] args) {
        String a ="tesab";
        char test[] = a.toCharArray();
        reverseString(test);

        for (char c : test) {
            System.out.println(c);
        }

    }

}
