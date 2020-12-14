/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.trainingcamp.first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，
 * 判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 * @author cwenao
 * @version $Id SumThreeNum.java, v1.0.0 2020-11-25 14:17 cwenao Exp $$
 */

public class SumThreeNum {

    public List<List<Integer>> threeSum(int[] nums) {

        return threeSumByDoublePoint(nums);
    }

    /**
     * 采用双指针的方式进行遍历
     * 指定K值循环 nums数组
     * 在循环内再用双指针进行遍历nums
     * @param nums
     * @return
     */
    private List<List<Integer>> threeSumByDoublePoint(int[] nums) {

        //排序：双指针需要数组有序
        Arrays.sort(nums);
        List<List<Integer>> resultList= new ArrayList<>();

        for (int k = 0; k < nums.length - 2; k++) {

            //a+b+c=0
            //nums 有序
            if (nums[k] > 0) {
                break;
            }

            //不允许重复
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }

            int i = k + 1;
            int j = nums.length - 1;

            while (i < j) {
                if (nums[k] + nums[i] + nums[j] == 0) {
                    List<Integer> tmp = new ArrayList<>(3);
                    tmp.add(nums[k]);
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    resultList.add(tmp);
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
        return resultList;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};

        SumThreeNum sumThreeNum = new SumThreeNum();
        sumThreeNum.threeSum(nums).stream().forEach(System.out::println);


    }

}
