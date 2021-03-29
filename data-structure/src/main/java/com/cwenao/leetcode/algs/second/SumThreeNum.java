/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断nums中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * @author cwenao
 * @version $Id SumThreeNum.java, v1.0.0 2021-03-29 11:02 cwenao Exp $$
 */
public class SumThreeNum {

    public List<List<Integer>> threeSum(int[] nums) {
        return threeSumByDoublePoint(nums);
    }

    /**
     * 双指针循环：
     *  1. 固定k值
     *  2. 定义i j双指针双端循环
     * @param nums
     * @return
     */
    private List<List<Integer>> threeSumByDoublePoint(int[] nums) {

        //从小到大排序
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        //i指针循环所以-2
        for (int k = 0; k < nums.length - 2; k++) {

            //a+b+c=0
            //数组nums有序
            //如果a>0则b c一定>0
            if (nums[k] > 0) {
                break;
            }
            //当前K与K-1相等则不需要再计算
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }

            //数组双端循环
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                if (nums[k] + nums[i] + nums[j] == 0) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[k]);
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    result.add(tmp);

                    while (i < j && nums[i] == nums[i + 1]) {
                        i++;
                    }
                    while (i < j && nums[j] == nums[j - 1]) {
                        j--;
                    }
                    i++;
                    j--;
                } else if (nums[k] + nums[i] + nums[j] < 0) {
                    i++;
                } else if (nums[k] + nums[i] + nums[j] > 0) {
                    j--;
                }
            }
        }
        return result;
    }
}
