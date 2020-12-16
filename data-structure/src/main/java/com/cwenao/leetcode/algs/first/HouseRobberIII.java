/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id HouseRobberIII.java, v1.0.0 2020-12-15 21:51 cwenao Exp $$
 */
public class HouseRobberIII {

    public int rob(TreeNode root) {

        Map<TreeNode, Integer> existing = new HashMap<>();
        return houseRobberByDP(root, existing);
    }

    private int houseRobberByDP(TreeNode root, Map<TreeNode, Integer> existing) {

        if (root == null) {
            return 0;
        }
        if (existing.containsKey(root)) {
            return existing.get(root);
        }

        int nearStep = root.val + (root.left == null ? 0 : houseRobberByDP(root.left.left, existing)
                + houseRobberByDP(root.left.right, existing))
                + (root.right == null ? 0 : houseRobberByDP(root.right.left, existing)
                + houseRobberByDP(root.right.right, existing));

        int farStep = houseRobberByDP(root.left, existing) + houseRobberByDP(root.right, existing);

        int result = Math.max(nearStep, farStep);

        existing.put(root, result);

        return result;
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {

    }


}
