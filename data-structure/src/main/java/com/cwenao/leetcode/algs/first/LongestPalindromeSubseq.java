/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id LongestPalindromeSubseq.java, v1.0.0 2020-12-19 09:50 cwenao Exp $$
 */
public class LongestPalindromeSubseq {
    public int longestPalindromeSubseq(String s) {
        return longestPalindromeSubseqByDP(s);
    }

    private int longestPalindromeSubseqByDP(String s) {

        //dp[i][j]: s[i:j]的最长回文子序列
        //反推
        //dp[i][j] = Math.max(dp[i+1][j],dp[i][j+1])
        //当i==j时：dp[i][j] = dp[i+1][j-1]+2

        int n = s.length();
        int[][] dp = new int[n][n];

        //i==j则为1
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = 1;
        }

        //回文：找到中间字符向两边扩散
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n-1];
    }

    public static void main(String[] args) {
        String s = "bbbab";
        LongestPalindromeSubseq longestPalindromeSubseq = new LongestPalindromeSubseq();
        System.out.println(longestPalindromeSubseq.longestPalindromeSubseq(s));
    }
}
