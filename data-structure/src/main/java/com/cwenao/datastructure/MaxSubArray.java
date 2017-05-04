/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure;

/**
 * 求一个最大子数组
 * 假设：数组下标 中值为mid，左边元素最小下标为low，右边最大下标为high
 * mid = (low + high) /2
 * 那么使用分治法的思想可以对任意长度>1的数组进行f分解
 * 针对一个数组最大的非空连续元素的和
 * 要么存在与 A[low...mid]中 要么存在 A[mid...high]
 * 或者存在与以mid为起点进行左右两边取最大然后求和： A[...mid...]
 * @author cwenao
 * @version $Id MaxSubArray.java, v 0.1 2017-05-03 21:07 cwenao Exp $$
 */
public class MaxSubArray {

    /**
     * 求中间最大字数组
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

    /**
     * 分治思想进行分解、解决、合并
     * 用递归方法进行分解合并：
     * 因为没有限制所以递推最后一层的时候是单个元素
     * 然后递归的时候进行解决合并
     * @param sub
     * @param low
     * @param high
     * @return
     */
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

