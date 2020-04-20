/**
 * Company Copyright (C) 2014-2019 All Rights Reserved.
 */
package com.cwenao.leetcode;

/**
 *
 * TODO : Statement the class description
 * @author cwenao
 * @version $Id MoveZeroesForArray.java, v1.0.0 2019-08-17 18:16 cwenao Exp $$
 */
public class MoveZeroesForArray {

    public void moveZeroes(int[] nums) {
        int count = 0;
        for (int i : nums) {
            if (i == 0) {
                count++;
            }
        }

        if (count != 0) {
            for (int x = 0; x < nums.length; x++) {
                if (nums[x] == 0) {
                    for (int j = x+1; j < nums.length; j++) {
                        if (nums[j] != 0) {
                            nums[x] = nums[j];
                            nums[j] = 0;
                            break;
                        }
                    }
                }
            }
        }

    }

    public void moveZeroes2(int[] nums) {
        int count = 0;
        for (int i : nums) {
            if (i == 0) {
                count++;
            }
        }

        if (count != 0) {
            int current = 0;
            for (int x = 0; x < nums.length; x++) {
                if (nums[x] != 0) {
                    int tmp = nums[current];
                    nums[current] = nums[x];
                    nums[x] = tmp;
                    current++;
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] test = new int[]{1,0};

        MoveZeroesForArray moveZeroesForArray = new MoveZeroesForArray();
        moveZeroesForArray.moveZeroes2(test);
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }
    }

}
