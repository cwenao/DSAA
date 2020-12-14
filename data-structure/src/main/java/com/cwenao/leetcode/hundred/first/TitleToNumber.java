/**
 * Company Copyright (C) 2014-2019 All Rights Reserved.
 */
package com.cwenao.leetcode.hundred.first;

/**
 *
 * 给定一个Excel表格中的列名称，返回其相应的列序号
 * 如：A ->1
 * 思路：认为A-Z为26进制，char为ASCII码，相减获取差值
 * @author cwenao
 * @version $Id TitleToNumber.java, v1.0.0 2019-07-04 23:16 cwenao Exp $$
 */
public class TitleToNumber {

    public int titleToNumber(String s) {
        int result =0;
        if (s == null || "".equals(s)) {
            return result;
        }
        char source[] = s.toCharArray();
        for (char tmp : source) {
            result = result * 26 + (tmp - 'A' + 1);
        }

        return result;

    }

    public static void main(String[] args) {
        TitleToNumber a = new TitleToNumber();
        String test = "A";

        System.out.println(a.titleToNumber(test));

    }

}
