/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.second;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id MinDistance.java, v1.0.0 2021-03-30 06:58 cwenao Exp $$
 */
public class MinDistance {
    public int minDistance(String word1, String word2) {
        return minDistanceByDP(word1, word2);
    }

    private int minDistanceByDP(String word1, String word2) {

        //dp[i][j]: 表示word1[0:i]与word2[0:j]的最小编辑距离
        //编辑距离分插入与删除、替换方式
        //插入: dp[i][j] = dp[i-1][j]+1
        //删除：dp[i][j] = dp[i][j-1]+1
        //替换：dp[i][j] = dp[i-1][j-1]+1
        //word1[i-1] == word2[j-1] : dp[i][j] = dp[i-1][j-1]
        //else : dp[i][j] = Math.min(dp[i-1][j-1]+1,Math.min(dp[i-1][j]+1,dp[i][j-1]+1))

        int slen = word1.length();
        int tlen = word2.length();
        int[][] dp = new int[slen + 1][tlen + 1];

        for (int i = 0; i <= slen; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= tlen; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= slen; i++) {
            for (int j = 1; j <= tlen; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                }
            }
        }

        return dp[slen][tlen];
    }


}
