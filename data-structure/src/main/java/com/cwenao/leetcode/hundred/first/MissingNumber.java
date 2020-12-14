/**
 * Company Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.hundred.first;

/**
 *
 * #268. 缺失数字
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * 示例 1:
 * 输入: [3,0,1]
 * 输出: 2
 * @author cwenao
 * @version $Id MissingNumber.java, v1.0.0 2020-03-03 20:41 cwenao Exp $$
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        //使用位运算
        //4^4 = 0, 4^4^4 = 4
        int num = nums.length;
        for (int i = 0; i < nums.length ; i++) {
            num ^= i ^ nums[i];
        }
        return num;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,0,1};
        MissingNumber missingNumber = new MissingNumber();
        System.out.println(missingNumber.missingNumber(nums));
    }
}
