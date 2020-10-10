/**
 * Company Copyright (C) 2014-2019 All Rights Reserved.
 */
package com.cwenao.leetcode.first;

/**
 *
 * #191. 位1的个数
 * 实际为计算汉明重量（https://baike.baidu.com/item/%E6%B1%89%E6%98%8E%E9%87%8D%E9%87%8F）
 * 根据位运算特点计算1个个数
 * 在二进制表示中，数字 n 中最低位的 1 总是对应 n - 1 中的 0
 * @author cwenao
 * @version $Id HammingWeight.java, v1.0.0 2019-08-17 16:50 cwenao Exp $$
 */
public class HammingWeight {

    public int hammingWeight(int n) {

        int count = 0;
        while (n != 0) {
            count++;
            n &= (n-1);
        }

        return count;
    }

    public static void main(String[] args) {

        HammingWeight h = new HammingWeight();

        int num = 4;

        System.out.println(Integer.toBinaryString(num));

        System.out.println(h.hammingWeight(num));
    }

}
