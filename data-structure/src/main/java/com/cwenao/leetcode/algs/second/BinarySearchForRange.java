/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.second;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id BinarySearchForRange.java, v1.0.0 2021-03-18 16:47 cwenao Exp $$
 */
public class BinarySearchForRange {

    public int[] searchRange(int[] nums, int target) {

        int left = searchRange2Left(nums, target);
        int right = searchRange2Right(nums, target);

        return new int[]{left, right};
    }

    private int searchRange2Right(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        if (right <0 || nums[right] != target) {
            return -1;
        }
        return right;
    }

    private int searchRange2Left(int[] nums, int target) {

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    public static void main(String[] args) {
        BinarySearchForRange searchForRange = new BinarySearchForRange();
        int[] test = new int[]{5,7,7,8,8,10};
        int target = 8;
        int[] range = searchForRange.searchRange(test, target);
        for (int x : range) {
            System.out.println(x);
        }
    }

}
