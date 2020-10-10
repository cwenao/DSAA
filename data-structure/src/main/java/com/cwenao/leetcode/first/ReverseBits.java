/**
 * Company Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.first;

/**
 *
 * #190.
 * 颠倒给定的 32 位无符号整数的二进制位。
 * 参考：https://mp.weixin.qq.com/s/99HVijYmbk1BrGVi1BqrCg
 * @author cwenao
 * @version $Id ReverseBits.java, v1.0.0 2020-03-02 21:45 cwenao Exp $$
 */
public class ReverseBits {
    public int reverseBits(int n) {

        int result = 0;

        for (int site = 31; site >= 0;  site--) {
            //n >> (31 - site) 将第site位数往右移动到最后位
            //((n >> (31 - site)) & 1) 将移动后的数取到
            //(((n >> (31 - site)) & 1) << site) 将获取到的数往左移动
            result = result | (((n >> (31 - site)) & 1) << site);
        }

        return result;
    }

    public static void main(String[] args) {
        ReverseBits reverseBits = new ReverseBits();
        System.out.println(reverseBits.reverseBits(43261596));
    }
}
