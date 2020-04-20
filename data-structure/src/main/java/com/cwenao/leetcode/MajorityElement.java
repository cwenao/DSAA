/**
 * Company Copyright (C) 2014-2019 All Rights Reserved.
 */
package com.cwenao.leetcode;

/**
 *
 * #169 给定一个大小为 n 的数组，找其中的众数。
 * [众数]是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 如：[1,2,3,1,1] 众数为[1]
 * 摩尔投票：
 * 即如果把 该众数记为 +1 ，把其他数记为 −1 ，将它们全部加起来，和是大于 0 的。
 * 如果出现次数 count == 0 ，则candidate = currentElement，
 * 遍历完数组中的所有数字即可得到结果
 *

 * @author cwenao
 * @version $Id MajorityElement.java, v1.0.0 2019-08-08 09:41 cwenao Exp $$
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {

        int count = 0;
        int candidate = 0;

        for (int x : nums) {
            if (count == 0) {
                candidate = x;
                count++;
            } else {
                if (candidate == x) {
                    count++;
                } else {
                    count--;
                }
            }
        }

        return candidate;
    }

    public static void main(String[] args) {
        int x[] = new int[]{1,2,1,3,4,1,2,2,2,2,2};

        MajorityElement  m= new MajorityElement();
        System.out.println(m.majorityElement(x));

    }
}
