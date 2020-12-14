/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id BinarySearch.java, v1.0.0 2020-12-13 13:48 cwenao Exp $$
 */
public class BinarySearch {

    public int search(int[] nums, int target) {
//        return searchBySimple(nums, target);
        int left = 0;
        int right = nums.length - 1;
        return searchByRecursive(nums, target, left, right);
    }

    private int searchByRecursive(int[] nums, int target, int left, int right) {

        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (nums[mid] == target) {
            return mid;
        }else if (nums[mid] < target) {
            mid = searchByRecursive(nums, target, mid + 1, right);
        } else if (nums[mid] > target) {
            mid = searchByRecursive(nums, target, left, mid - 1);
        }

        return mid;
    }

    private int searchBySimple(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;

        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.search(nums, target));
    }

}
