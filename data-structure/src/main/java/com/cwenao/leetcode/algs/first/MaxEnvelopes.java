/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

import java.util.Arrays;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id MaxEnvelopes.java, v1.0.0 2020-12-18 14:45 cwenao Exp $$
 */
public class MaxEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        return maxEnvelopesByDP(envelopes);
    }

    private int maxEnvelopesByDP(int[][] envelopes) {

        Arrays.sort(envelopes, (a, b) ->{
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int[] height = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            height[i] = envelopes[i][1];
        }

        return findMaxByDP(height);
    }

    private int findMaxByDP(int[] height) {

        //dp[i]: height[i]数组i元素的最大子序列长度为dp[i]
        //dp[i]: dp[i] = max(dp[i],dp[j]+1);
        //dp[j]: 为height[j]时的最大子序列长度
        int[] dp = new int[height.length];

        //每个元素的子序列都包含自身
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }

        int len = height.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) { //重点注意
                if (height[i] > height[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int result = 0;
        for (int x : dp) {
            result = Math.max(result, x);
        }
        return result;
    }

    public static void main(String[] args) {
//        int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        int[][] envelopes = {{30, 50}, {12, 2}, {3, 4}, {12, 15}};
        MaxEnvelopes maxEnvelopes = new MaxEnvelopes();
        System.out.println(maxEnvelopes.maxEnvelopes(envelopes));
    }

}
