/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id DeleteTowWordsMinDistance.java, v1.0.0 2020-12-18 16:25 cwenao Exp $$
 */
public class DeleteTowWordsMinDistance {

    public int minDistance(String word1, String word2) {
        return minDistanceByDP(word1, word2);
    }

    private int minDistanceByDP(String word1, String word2) {

        //删除最少步骤则需要找到word1与word2最长公共子序列
        //dp[i][j]: word1[0:i]与word2[0:j]的最长公共子序列

        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int lcs = dp[m][n];

        return m + n - 2 * lcs;
    }

    public static void main(String[] args) {
        String word1 = "sea", word2 = "eat";
        DeleteTowWordsMinDistance deleteTowWordsMinDistance = new DeleteTowWordsMinDistance();
        System.out.println(deleteTowWordsMinDistance.minDistance(word1, word2));
    }
}
