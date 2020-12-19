/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id RegularExpressionMatch.java, v1.0.0 2020-12-19 17:31 cwenao Exp $$
 */
public class RegularExpressionMatch {

    public boolean isMatch(String s, String p) {
        return isMatchByDP(s, p);
    }

    private boolean isMatchByDP(String s, String p) {

        //dp[i][j] : s[0:i]与p[0:j] 匹配的结果
        // if p.charAt(j-1) == "*" :  dp[i][j] = dp[i][j-2]
        //          if s[i-1] == p[j-1] : dp[i][j] = dp[i][j] || dp[i - 1][j]
        //else                     :  dp[i][j] = dp[i-1][j-1]

        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (matches(s, p, i, j-1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }else{
                    if (matches(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }

        return dp[m][n];
    }

    private boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j-1) == '.') {
            return true;
        }

        return s.charAt(i - 1) == p.charAt(j - 1);
    }

}
