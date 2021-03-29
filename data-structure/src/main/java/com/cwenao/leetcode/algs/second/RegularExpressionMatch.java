/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.second;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id RegularExpressionMatch.java, v1.0.0 2021-03-29 22:02 cwenao Exp $$
 */
public class RegularExpressionMatch {

    public boolean isMatch(String s, String p) {
        return isMatchByDP(s, p);
    }

    private boolean isMatchByDP(String s, String p) {

        //dp[i][j]: s[0:i]与p[0:j]匹配的结果
        //p.charAt(j-1) == '*' then dp[i][j] = dp[i][j-2]
        //      s[i-1] == p[j-1] then dp[i][j] = dp[i][j] | dp[i-1][j]
        //p.charAt(j-1) != '*' then dp[i][j] = dp[i-1][j-1]

        int slen = s.length();
        int plen = p.length();
        boolean[][] dp = new boolean[slen + 1][plen + 1];
        dp[0][0] = true;

        for (int i = 0; i <= slen; i++) {
            for (int j = 1; j <= plen; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        dp[i][j] = dp[i][j] | dp[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }

        return dp[slen][plen];
    }

    private boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

}
