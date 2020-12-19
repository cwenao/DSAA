/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id MinimumDeleteSum.java, v1.0.0 2020-12-18 16:45 cwenao Exp $$
 */
public class MinimumDeleteSum {
    public int minimumDeleteSum(String s1, String s2) {
        return minimumDeleteSumByDP(s1, s2);
    }

    private int minimumDeleteSumByDP(String s1, String s2) {

        //dp[i][j]: s1[i:]与s2[j:]达到相同需要删除最小和
        //s1[i:] s2[j:] 表示 i..s1.length j..s2.length
        //dp[i][j] = Math.min(dp[i+1][j] + s1.codePointAt(i), dp[i][j+1] +s2.codePointAt(j))

        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        //s2 == ""
        for (int i = m -1; i >= 0; i--) {
            dp[i][n] = dp[i + 1][n] + s1.codePointAt(i);
        }
        //s1 == ""
        for (int i = n-1; i >=0 ; i--) {
            dp[m][i] = dp[m][i + 1] + s2.codePointAt(i);
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j] + s1.codePointAt(i),
                            dp[i][j + 1] + s2.codePointAt(j));
                }
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        MinimumDeleteSum minimumDeleteSum = new MinimumDeleteSum();
        String s1 = "sea", s2 = "eat";
        System.out.println(minimumDeleteSum.minimumDeleteSum(s1, s2));
    }
}
