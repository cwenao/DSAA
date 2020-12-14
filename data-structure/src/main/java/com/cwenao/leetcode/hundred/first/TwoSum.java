/**
 * Company Copyright (C) 2014-2019 All Rights Reserved.
 */
package com.cwenao.leetcode.hundred.first;

/**
 *
 * TODO : Statement the class description
 * @author cwenao
 * @version $Id TwoSum.java, v1.0.0 2019-02-16 12:55 cwenao Exp $$
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        for(int i=0; i<nums.length; i++){
            for(int x= i+1;x<nums.length;x++){
                if(nums[i]+nums[x] == target){
                    return new int[]{i,x};
                }
            }
        }
        return null;
    }
    public static void main(String[] args) {
        int nums[] = new int[]{2,7,3,5};
        int result[] = twoSum(nums,10);
        for (int x : result) {
            System.out.println(x);
        }
    }

}
