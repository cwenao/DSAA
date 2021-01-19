/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

import java.util.Arrays;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id CountPrimes.java, v1.0.0 2021-01-19 12:19 cwenao Exp $$
 */
public class CountPrimes {

    public int countPrimes(int n) {
        boolean[] isPrimes = new boolean[n];
        Arrays.fill(isPrimes, true);

        //i*i <n : i*i之后的为重复数字
        for (int i = 2; i * i < n; i++) {
            if (isPrimes[i]) {
                //当前为素数，则其倍数都非素数
                for (int j = i * i; j < n; j += i) {
                    isPrimes[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimes[i]) {
                count++;
            }
        }

        return count;
    }

}
