/**
 * Company Copyright (C) 2014-2019 All Rights Reserved.
 */
package com.cwenao.leetcode;

/**
 *
 * #108. 将有序数组转换为二叉搜索树
 *  将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *  平衡二叉树：对于每个根节点，左右子树高度差 <= 1；
 *  二叉搜索树：对于每个节点，其左子树值<此节点值，右子树>此节点值
 * @author cwenao
 * @version $Id SortedArrayToBST.java, v1.0.0 2019-07-03 23:02 cwenao Exp $$
 */
public class SortedArrayToBST {

    public TreeNode sortedArray2BST(int nums[]) {
        return buildBST(nums, 0, nums.length-1);
    }

    private TreeNode buildBST(int nums[], int low, int high) {

        if (low > high) {
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, low, mid - 1);
        root.right = buildBST(nums, mid + 1, high);
        return root;
    }

    public static void main(String[] args) {
        int nums[] = {-10,-3,-1,0,5,9,13};
        SortedArrayToBST sortedArrayToBST = new SortedArrayToBST();
        TreeNode treeNode = sortedArrayToBST.sortedArray2BST(nums);

        System.out.println(treeNode);

    }

}
