/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure;

/**
 * 求一个最大子数组
 * @author cwenao
 * @version $Id MaxSubArray.java, v 0.1 2017-05-03 21:07 cwenao Exp $$
 */
public class MaxSubArray {

    /**
     * 求中间最大字数组
     *
     * @param sub
     */
    public static int maxCrossingSubArray(int[] sub,int low,int mid,int high) {

        Integer leftSum = null;
        int temp = 0;
        for (int i = mid; i >= low; i--) {
            if (null == leftSum) {
                leftSum = sub[i];
                temp = leftSum;
                continue;
            }

            temp = temp + sub[i];

            if (temp > leftSum) {
                leftSum = temp;
            }
        }

        Integer rightSum = null;
        temp = 0;
        for(int i= mid+1; i<=high ;i++) {
            if (null == rightSum) {
                rightSum = sub[i];
                temp = rightSum;
                continue;
            }
            temp = temp + sub[i];

            if (temp > rightSum) {
                rightSum = temp;

            }
        }

        return leftSum + rightSum;
    }

    public static int maxSubArray(int[] sub, int low, int high) {
        if (low == high) {
            return sub[low];
        }

        int mid = (low + high) / 2;

        int leftSum = maxSubArray(sub, low, mid);
        int rightSum = maxSubArray(sub, mid + 1, high);
        int midSum = maxCrossingSubArray(sub, low, mid, high);

        int max = leftSum;
        if(rightSum > max) {
            max = rightSum;
        }
        if (midSum > max) {
            max = midSum;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] maxSubArrays = new int[]{13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        System.out.println(maxSubArray(maxSubArrays, 0, maxSubArrays.length - 1));
    }
}

