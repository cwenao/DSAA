/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.second;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id HouseRobberIII.java, v1.0.0 2021-03-24 21:08 cwenao Exp $$
 */
public class HouseRobberIII {

    public int rob(TreeNode root) {
        return robberIIIByDP(root);
    }

    private int robberIIIByDP(TreeNode root) {
        //当前为树状房子，需要先遍历完成树上的房子
        //dp[i][h] 为偷/不偷当前节点所获取的最大值

        int[] result = robberIIIByDPAndDFS(root);

        return Math.max(result[0],result[1]);
    }

    private int[] robberIIIByDPAndDFS(TreeNode root) {

        //dp[i][h]: 当前第i个节点偷/不偷所获取的最大值
        //h: 0 不偷，1 偷
        //dp[i][0] = Math.max(dp[left][0],dp[left][1])+Math.max(dp[right][0],dp[right][1])
        //dp[i][1] = dp[root][1]+dp[left][0]+dp[right][0]

        if (root == null) {
            return new int[]{0,0};
        }
        //后续遍历,各个节点
        int[] left = robberIIIByDPAndDFS(root.left);
        int[] right = robberIIIByDPAndDFS(root.right);

        //树状节点 后续遍历需要向上汇总信息，所以简略变量i
        int[] dp = new int[2];
        //dp[0]：不偷
        //dp[1]: 偷
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        dp[1] = root.val + left[0] + right[0];
        //返回偷与不偷的值
        return dp;
    }

    public class TreeNode{

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

}
