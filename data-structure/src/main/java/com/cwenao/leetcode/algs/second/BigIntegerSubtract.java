/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.second;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id BigIntegerSubtract.java, v1.0.0 2021-03-28 23:19 cwenao Exp $$
 */
public class BigIntegerSubtract {

    private final static long LONG_MASK = 0xffffffffL;

    public int[] subtract(int[] big, int[] little) {
        int bigIndex = big.length;
        int littleIndex = little.length;
        int[] result = new int[bigIndex];
        long subResult = 0L;

        while (littleIndex > 0) {
            //LONG_MASK 转化为long型
            subResult = (big[--bigIndex] & LONG_MASK) - (little[--littleIndex] & LONG_MASK) + (subResult >> 32);
            result[bigIndex] = (int) subResult;
        }

        boolean borrow = (subResult >> 32 != 0);
        while (bigIndex > 0 && borrow) {
            borrow = ((result[--bigIndex] = big[bigIndex] - 1) == -1);
        }

        while (bigIndex > 0) {
            result[--bigIndex] = big[bigIndex];
        }
        return result;
    }

    public static void main(String[] args) {
        BigIntegerSubtract bigIntegerSubtract = new BigIntegerSubtract();
        int[] big = Arrays.stream("1234567890986445347688".chars().toArray()).map(i->(int) i-'0').toArray();
        int[] little = new int[]{1};
        int[] result = bigIntegerSubtract.subtract(big, little);
        System.out.println(Arrays.stream(result).boxed().map(i->i.toString()).collect(Collectors.joining("")));
    }

}
