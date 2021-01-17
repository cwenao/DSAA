/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id Multiply2String.java, v1.0.0 2021-01-17 12:39 cwenao Exp $$
 */
public class Multiply2String {

    public String multiply(String num1, String num2) {
        char[] nums1 = num1.toCharArray();
        char[] nums2 = num2.toCharArray();

        List<Integer> result = new ArrayList<>(nums1.length + nums2.length);
        for (int i = 0; i < nums1.length + nums2.length; i++) {
            result.add(i, 0);
        }

        for (int i = nums1.length -1; i >=0; i--) {
            for (int j = nums2.length-1; j >=0; j--) {
                int mul = (nums1[i] - '0') * (nums2[j] - '0');
                int p1 = i + j;
                int p2 = i + j + 1;

                int sum = mul + (result.size() > p2 ? result.get(p2) : 0);
                result.set(p2, sum % 10);
                result.set(p1, result.get(p1) +( sum / 10));
            }
        }

        int zeroNum = 0;
        while (zeroNum < result.size() && result.get(zeroNum) == 0) {
            zeroNum++;
        }
        StringBuffer resultStr = new StringBuffer();

        for (int i = zeroNum ; i < result.size(); i++) {
            resultStr.append(result.get(i));
        }

        return resultStr.toString().equals("") ? "0" : resultStr.toString();
    }

    public static void main(String[] args) {
        Multiply2String multiply2String = new Multiply2String();
        System.out.println(multiply2String.multiply("123", "456"));
    }

}
