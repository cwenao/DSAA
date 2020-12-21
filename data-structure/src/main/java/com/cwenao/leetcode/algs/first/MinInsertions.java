/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id MinInsertions.java, v1.0.0 2020-12-20 09:05 cwenao Exp $$
 */
public class MinInsertions {

    public int minInsertions(String s) {
        return minInsertionsByDP(s);
    }

    private int minInsertionsByDP(String s) {

        //dp[i][j]: s[i:j]成回文最少需要插入的次数
        //当s[i] == s[j] -> 最外层已经回文，则dp[i][j] = dp[i+1][j-1]
        //当s[i] != s[j] -> 需要构建最外层回文，要么将s[j]插dao s[i+1:j]的最左边形成s[i:j]为回文，
        //要么将s[i]插到 s[i:j-1]的最右边使s[i:j]形成回文
        //dp[i][j] = min(dp[i+1][j],dp[i][j-1]) +1

        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }

        return dp[0][n-1];
    }

    public static void main(String[] args) {
        String s = "mbadm";
        MinInsertions minInsertions = new MinInsertions();
        System.out.println(minInsertions.minInsertions(s));

    }

}
