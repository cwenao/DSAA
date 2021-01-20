/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id SuperPow.java, v1.0.0 2021-01-20 08:36 cwenao Exp $$
 */
public class SuperPow {

    int base = 1337;

    public int superPow(int a, int k) {
        return superPowByRecursive(a, k);
    }

    private int superPowByRecursive(int a, int k) {
        if (k == 0) {
            return 1;
        }
        a %= base;
        if (k % 2 == 1) {
            return a * (superPowByRecursive(a, k - 1)) % base;
        } else {
            int sub = superPowByRecursive(a, k / 2);
            return sub * sub % base;
        }
    }

    public static void main(String[] args) {

    }
}
