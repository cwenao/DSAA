/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.trainingcamp.first;

import java.util.Arrays;

/**
 *
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * @author cwenao
 * @version $Id MoveZeroes.java, v1.0.0 2020-11-23 10:54 cwenao Exp $$
 */
public class MoveZeroes {

    /**
     * 示例:
     *
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 说明:
     *
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     *
     */

    public void moveZeroes(int[] nums) {
        moveZeroesByDoublePoint(nums);
    }

    private void moveZeroesByDoublePoint(int[] nums) {

        if (nums == null || nums.length == 0) {
            System.out.println("当前数组为null 或者数组长度为0");
            return;
        }

        int fastIndex = 0, slowIndex = 0, len = nums.length;
        while (fastIndex < len) {
            if (nums[fastIndex] != 0) {

                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
            fastIndex++;
        }

        for (int i = slowIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] zeroes = new int[]{0, 15 ,1, 0, 3,0,0,2, 12,0};
        moveZeroes.moveZeroes(zeroes);

        Arrays.stream(zeroes).forEach(System.out::println);

    }

}
