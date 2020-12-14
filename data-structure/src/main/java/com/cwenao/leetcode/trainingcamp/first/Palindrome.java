/**
 * Company Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.trainingcamp.first;

/**
 * 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 * @author cwenao
 * @version $Id Palindrome.java, v1.0.0 2020-10-17 09:17 cwenao Exp $$
 */
public class Palindrome {

    /**
     * 解法1：使用现成的工具类（正则、StringBuilder的reverse）
     * @param s
     * @return
     */

    public boolean isPalindrome(String s) {
        //1.过滤非字母与数字字符
        //2、reverse and compare

        String filterResult = filterNonNumberAndChar(s);

        return reverseString(filterResult).equalsIgnoreCase(filterResult);

    }

    private String filterNonNumberAndChar(String s) {

        return s.replaceAll("[^a-zA-Z0-9]", "");

    }

    private String reverseString(String filterResult) {

        return new StringBuilder(filterResult).reverse().toString();

    }

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        String testCase = "A man, a plan, a canal: Panama";
        System.out.println(palindrome.isPalindrome(testCase));
    }
}
