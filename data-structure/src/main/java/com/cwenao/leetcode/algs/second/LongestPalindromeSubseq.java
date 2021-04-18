/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.second;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id LongestPalindromeSubseq.java, v1.0.0 2021-04-13 15:31 cwenao Exp $$
 */
public class LongestPalindromeSubseq {
    public int longestPalindromeSubseq(String s) {
        return longestPalindromeSubseqByDP(s);
    }

    private int longestPalindromeSubseqByDP(String s) {

        //dp[i][j]: 字符串s[i:j]的最长回文串长度
        //dp[i][j] = Math.max(dp[i][j+1],dp[i+1][j])
        //s.charAt(i) == s.charAt(j)
        //则 dp[i][j] = dp[i+1][j-1]+2
        int len = s.length();
        int[][] dp = new int[len][len];

        //b
        //a
        //b
        //b b a b
        //i==j 则dp[i][j]=1
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }

        //回文需要找到中间字符
        //然后向两边扩展
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        return dp[0][len - 1];
    }
    public static void main(String[] args) {
        String s = "bbbab";
        com.cwenao.leetcode.algs.first.LongestPalindromeSubseq longestPalindromeSubseq = new com.cwenao.leetcode.algs.first.LongestPalindromeSubseq();
        System.out.println(longestPalindromeSubseq.longestPalindromeSubseq(s));
    }
}

