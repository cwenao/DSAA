/**
 * Company Copyright (C) 2014-2019 All Rights Reserved.
 */
package com.cwenao.leetcode;

/**
 *
 * #104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * 使用深度优先来完成搜索
 * @author cwenao
 * @version $Id MaxDepthForBinaryTree.java, v1.0.0 2019-06-30 16:46 cwenao Exp $$
 */
public class MaxDepthForBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }

    /**
     * 构建完全二叉树
     * 数组index=0保留
     * node.left = 2*N
     * node.right = 2*N+1
     * @param root
     * @param tree
     * @param currentIndex
     * @return
     */
    public TreeNode buildTreeNode(TreeNode root,Integer tree[],Integer currentIndex) {

        if (root == null) {
            return null;
        } else {
            int depth = 2 * currentIndex;
            if (depth + 1 < tree.length) {
                root.value = tree[currentIndex];

                    if (tree[depth] == null) {
                    } else {
                        root.left = buildTreeNode(new TreeNode(tree[depth]), tree, depth);
                    }

                    if (tree[depth + 1] != null) {
                        root.right = buildTreeNode(new TreeNode(tree[depth + 1]), tree, depth + 1);
                    } else {
//                        return null;
                    }

            }
            return root;
        }
    }

    public static void main(String[] args) {

//        给定二叉树 [3,9,20,null,null,15,7]，
        //完全二叉树构建
        Integer tree[] = {0,3,9,20,null,null,15,7,null,null,null,null,33,34,35,36};

        TreeNode root = new TreeNode(3);
        MaxDepthForBinaryTree tmp = new MaxDepthForBinaryTree();
        tmp.buildTreeNode(root,tree,1);

        System.out.println(root);
        System.out.println(tmp.maxDepth(root));

    }

}
