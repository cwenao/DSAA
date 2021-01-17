/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

import java.util.Arrays;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id EatGrepas.java, v1.0.0 2021-01-17 08:58 cwenao Exp $$
 */
public class EatGrapes {

    public long solution(long a, long b, long c) {
        long[] nums = new long[]{a, b, c};
        long sum = 0;
        Arrays.sort(nums);

        for (long num : nums) {
            sum += num;
        }
        //吃的最多的人吃的最小数量需要满足尽可能均分
        //吃的最多的那个人吃掉的葡萄颗数就是(a+b+c)/3向上取整的结果，也就是(a+b+c+2)/3

        if (nums[0] + nums[1] > nums[2]) {
            return (sum + 2) / 3;
        }

        // 不能构成三角形，平分最长边的情况
        if (2 * (nums[0] + nums[1]) < nums[2]) {
            return (nums[2] + 1) / 2;
        }

        // 不能构成三角形，但依然可以完全平分的情况
        return (sum + 2) / 3;
    }

}
