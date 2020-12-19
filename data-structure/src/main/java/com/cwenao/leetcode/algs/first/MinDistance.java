/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id MinDistance.java, v1.0.0 2020-12-18 10:57 cwenao Exp $$
 */
public class MinDistance {
    public int minDistance(String word1, String word2) {
        return minDistanceByDP(word1, word2);
    }

    private int minDistanceByDP(String word1, String word2) {
        int sourceLen = word1.length();
        int targetLen = word2.length();
        int[][] dp = new int[sourceLen + 1][targetLen + 1];

        for (int i = 0; i <= sourceLen; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= targetLen; i++) {
            dp[0][i] = i;
        }
        //dp[i][j]状态方程：表示word1[0:i]与word2[0:j]的最小编辑距离
        //1. if word1[i-1] = word2[j-1] ==> dp[i][j] = dp[i-1][j-1]
        //2. else ==> dp[i][j] = min(dp[i-1][j-1]+1,dp[i][j-1],dp[i-1][j])
        //insert：dp[i-1][j] 基础上做insert得到dp[i][j]
        //delete: dp[i][j-1] 基础上做delete得到dp[i][j]

        for (int i = 1; i <= sourceLen; i++) {
            for (int j = 1; j <= targetLen; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1,
                            Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                }
            }
        }
        return dp[sourceLen][targetLen];
    }

    public static void main(String[] args) {
        String word1 = "horse", word2 = "ros";
        MinDistance minDistance = new MinDistance();
        System.out.println(minDistance.minDistance(word1, word2));
    }
}
