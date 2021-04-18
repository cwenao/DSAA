/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.second;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id LongestCommonSubsequence.java, v1.0.0 2021-03-30 08:29 cwenao Exp $$
 */
public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        return longestCommonSubsequenceByDP(text1, text2);
    }

    private int longestCommonSubsequenceByDP(String text1, String text2) {

        //dp[i][j]: text1[0:i]与text2[0:j]的最长公共子序列
        //text1匹配：dp[i][j] = dp[i-1][j] +1
        //text2匹配: dp[i][j] = dp[i][j-1]+

        int t1len = text1.length();
        int t2len = text2.length();
        int[][] dp = new int[t1len + 1][t2len + 1];

        for (int i = 0; i <= t1len; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= t2len; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= t1len; i++) {
            for (int j = 1; j < t2len; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                }
            }
        }

        return dp[t1len][t2len];
    }
}
