/**
 * Company Copyright (C) 2014-2019 All Rights Reserved.
 */
package com.cwenao.leetcode;

/**
 *
 * #136.给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 算法应该具有线性时间复杂度,不使用额外空间来实现.
 * XOR运算
 * 1、交换律
 * 2、结合律（即(a^b)^c == a^(b^c)）
 * 3、对于任何数x，都有x^x=0，x^0=x
 * 4、自反性:  a^b^b=a^0=a;
 * 异或运算最常见于多项式除法，不过它最重要的性质还是自反性：A XOR B XOR B = A，
 * 即对给定的数A，用同样的运算因子（B）作两次异或运算后仍得到A本身。
 * ---------------------
 * @author cwenao
 * @version $Id SearchSingleNumber.java, v1.0.0 2019-07-11 11:24 cwenao Exp $$
 */
public class SearchSingleNumber {

    public int singleNumber(int[] nums) {

        int result = 0;
        for (int x : nums) {
            result ^= x;
        }

        return result;
    }

    public static void main(String[] args) {
        SearchSingleNumber searchSingleNumber = new SearchSingleNumber();
        int test[] = {1, 2, 1, 3, 5, 2, 9, 7,3, 5, 9};
        System.out.println(searchSingleNumber.singleNumber(test));
    }

}
