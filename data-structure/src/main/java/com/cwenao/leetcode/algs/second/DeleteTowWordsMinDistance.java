/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.second;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id DeleteTowWordsMinDistance.java, v1.0.0 2021-04-09 11:20 cwenao Exp $$
 */
public class DeleteTowWordsMinDistance {

    public int minDistance(String word1, String word2) {
        return minDistanceByDP(word1, word2);
    }

    private int minDistanceByDP(String word1, String word2) {
        //删除最少步骤则需要找到word1与word2最长公共子序列
        //dp[i][j]: word1[0:i]与word2[0:j]的最长公共子序列
        //if word1.charAt(i-1) == word2.charAt(j-1)
        //  dp[i][j] = dp[i-1][j-1]+1
        //else
        //  dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1])
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int lcs = dp[len1][len2];

        return len1 + len2 - 2 * lcs;
    }
}
