/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id FindDuplicateSubtreesByDFS.java, v1.0.0 2020-12-28 16:18 cwenao Exp $$
 */
public class FindDuplicateSubtreesByDFS {

    private List<TreeNode> ans = new ArrayList<>();

    private Map<String, Integer> count = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        findDuplicateSubtreesByDFS(root);

        return ans;
    }

    private String  findDuplicateSubtreesByDFS(TreeNode node) {

        if (node == null) {
            return "-";
        }

        String tempKey = node.val + '|' + findDuplicateSubtreesByDFS(node.left) + "|"
                + findDuplicateSubtreesByDFS(node.right);

        count.put(tempKey, count.getOrDefault(tempKey, 0) + 1);

        if (count.get(tempKey) == 2) {
            ans.add(node);
        }

        return tempKey;
    }

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
