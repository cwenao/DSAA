/**
 * Company Copyright (C) 2014-2019 All Rights Reserved.
 */
package com.cwenao.leetcode.first;

/**
 *
 * TODO : Statement the class description
 * @author cwenao
 * @version $Id Palindrome.java, v1.0.0 2019-02-21 19:49 cwenao Exp $$
 */
public class Palindrome {

    public static boolean isPalindrome(int x) {

        if (x < 0 || (x % 10 ==0 && x!=0)) {
            return false;
        } else if (x >0 && x<10) {
            return true;
        }
        char toConvert[] = String.valueOf(x).toCharArray();

        int length = toConvert.length;
        for (int i = 0; i < (length - (i + 1)); i++) {
            if (toConvert[i] != toConvert[length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

}
