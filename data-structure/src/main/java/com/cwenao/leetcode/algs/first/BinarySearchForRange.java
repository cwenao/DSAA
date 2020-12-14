/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id BinarySearchForRange.java, v1.0.0 2020-12-13 14:14 cwenao Exp $$
 */
public class BinarySearchForRange {

    public int[] searchRange(int[] nums, int target) {

        int left = searchByLeftBound(nums, target);
        int right = searchByRightBound(nums, target);

        return new int[]{left, right};
    }

    private int searchByLeftBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }

        if (left >= nums.length || nums[left] != target) {
            return -1;
        }

        return left;
    }

    private int searchByRightBound(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }

        if (right < 0 || nums[right] != target) {
            return -1;
        } else {
            return right;
        }
    }

    public static void main(String[] args) {
        BinarySearchForRange binarySearchForRange = new BinarySearchForRange();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = binarySearchForRange.searchRange(nums, target);

        for (int x : result) {
            System.out.println(x);
        }
    }

}
