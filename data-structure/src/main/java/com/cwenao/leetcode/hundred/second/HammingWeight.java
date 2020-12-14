/**
 * Company Copyright (C) 2014-2019 All Rights Reserved.
 */
package com.cwenao.leetcode.hundred.second;

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
        return hammingWeightByBitMoved(n);
    }

    /**
     * 利用掩码进行与运算依次按位进行检测
     * 将数字n与掩码mask=1进行与运算，当结果不为0时则+1
     * mask<<1 再次进行与运行
     * @param n
     * @return
     */
    private int hammingWeightByBitMoved(int n) {
        int result = 0;
        int mask = 1;

        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                result++;
            }
            mask <<= 1;
        }

        return result;
    }

    /**
     * 利用n与n-1进行与运算，将当前位中的1替换位0
     * 最终达到n=0
     * @param n
     * @return
     */
    private int hammingWeightByBitZero(int n) {
        int result = 0;
        while (n != 0) {
            result++;
            n &= n - 1;
        }
        return result;
    }


    public static void main(String[] args) {
        HammingWeight hammingWeight = new HammingWeight();
        System.out.println(hammingWeight.hammingWeight(3));
        System.out.println(hammingWeight.hammingWeightByBitZero(3));
    }

}
