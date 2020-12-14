/**
 * Company Copyright (C) 2014-2019 All Rights Reserved.
 */
package com.cwenao.leetcode.hundred.first;

/**
 * #202. 快乐数
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，
 * 也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/happy-number
 *
 * 解题思路：
 * 1. 使用快慢指针判断是否是无限循环
 * 2. 快慢指针的原理为快指针步长为慢指针的2N倍，如果快指针所得值与慢指针相同且不为1则认为是环形无限循环
 * 3. 否则为快乐数
 *
 * @author cwenao
 * @version $Id HappyNumber.java, v1.0.0 2019-09-25 16:26 cwenao Exp $$
 */
public class HappyNumber {

    public boolean isHappy(int n) {

        boolean result = false;

        int slow= n;
        int fast = bitSquareSum(n);

        while (slow != fast) {
            slow = bitSquareSum(slow);
            fast = bitSquareSum(fast);
            fast = bitSquareSum(fast);
        }

        if (slow == 1) {
            result = true;
        }

        return result;
    }

    private int bitSquareSum(int n) {

        int sum = 0;

        while (n > 0) {
            int tmp = n % 10;
            sum += tmp * tmp;
            n = n/10;
        }

        return sum;
    }

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        System.out.println(happyNumber.isHappy(19));
    }

}
