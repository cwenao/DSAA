/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id CorpFlightBookings.java, v1.0.0 2021-01-14 22:16 cwenao Exp $$
 */
public class CorpFlightBookings {

    public int[] corpFlightBookings(int[][] bookings, int n) {

        int[] nums = new int[n];
        //利用差分数组
        //bookings[0] = [1,2,10] means nums[1:2] +10

        Difference difference = new Difference(nums);

        for (int[] booking : bookings) {
            difference.increment(booking[0] - 1, booking[1] - 1, booking[2]);
        }
        return difference.result();
    }

    //差分数组
    class Difference{

        private int[] diff;

        public Difference(int[] nums) {
            diff = new int[nums.length];
            diff[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }

        public void increment(int i, int j, int val) {
            diff[i] += val;
            if (j + 1 < diff.length) {
                diff[j + 1] -= val;
            }
        }

        public int[] result() {
            int[] result = new int[diff.length];
            result[0] = diff[0];

            for (int i = 1; i < diff.length; i++) {
                result[i] = diff[i] + result[i - 1];
            }

            return result;
        }

    }

}
