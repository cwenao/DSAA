/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.second;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id MinInsertions.java, v1.0.0 2021-03-29 23:36 cwenao Exp $$
 */
public class MinInsertions {
    public int minInsertions(String s) {
        return minInsertionsByDP(s);
    }

    private int minInsertionsByDP(String s) {

        //dp[i][j]: s[i:j]成回文最少需要插入的次数
        //s[i] == s[j] -> 最外层已经回文，dp[i][j] = dp[i+1][j-1]
        //s[i] != s[j] -> 需要构建最外层回文
        // 1. 将s[j]插入到s[i+1:j]的最左侧构成回文
        // 2. 将s[i]插入到s[i:j-1]的最右侧构成回文
        // dp[i][j] = Math.min(dp[i+1][j],dp[i][j-1]) +1

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

        return dp[0][n - 1];
    }

}
