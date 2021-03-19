/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.second;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id BinarySearch.java, v1.0.0 2021-03-18 16:05 cwenao Exp $$
 */
public class BinarySearch {

    public int search(int[] nums, int target) {

//        int index = searchByWhile(nums, target);
        int index = searchByRecursive(nums, target,0,nums.length-1);
        return index;
    }

    private int searchByRecursive(int[] nums, int target, int low, int high) {

        if (low <= high) {

            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                mid = searchByRecursive(nums, target, low, mid - 1);
            }
            if (nums[mid] < target) {
                mid = searchByRecursive(nums, target, mid + 1, high);
            }
            return mid;
        }
        return -1;
    }

    private int searchByWhile(int[] nums, int target) {

        int low = 0, high = nums.length-1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                high = mid - 1;
            }
            if (nums[mid] < target) {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,3,5,9,12};
        int target = 9;

        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.search(nums,target));
    }
}
