/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id LongestCommonSubsequence.java, v1.0.0 2020-12-18 16:10 cwenao Exp $$
 */
public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        return longestCommonSubsequenceByDP(text1, text2);
    }

    private int longestCommonSubsequenceByDP(String text1, String text2) {

        //dp[i][j]: text1[0:i]与text2[0:j]的最长公共子序列
        //if  text1[i] == text2[j]: dp[i][j] = dp[i-1][j-1]+1
        //else :                    dp[i][j] = max(dp[i-1][j]+1,dp[i][j-1]+1)

        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }

    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace";
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        System.out.println(longestCommonSubsequence.longestCommonSubsequence(text1,text2));
    }

}
