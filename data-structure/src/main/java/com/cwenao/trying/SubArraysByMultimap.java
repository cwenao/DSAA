/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * find the serial sub-array when the sum is 0
 * 此题找的是连续的数组，最开始在推算此写法的一直是认为错误，打算改写
 * 最后在示例中看到获取的sub-array是连续数组
 * @author cwenao
 * @version $Id SubArraysByMultimap.java, v 0.1 2017-06-24 10:05 cwenao Exp $$
 */
public class SubArraysByMultimap {

    private static void insertMap(Map<Integer, List<Integer>> hashMap,
                                  Integer key, Integer index) {
        if (hashMap.containsKey(key)) {
            hashMap.get(key).add(index);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(index);
            hashMap.put(key, list);
        }

    }

    private static void resolveArray(int[] array) {

        Map<Integer, List<Integer>> hashMap = new HashMap<>();
        int sum = 0;
        insertMap(hashMap,sum, -1);

        for(int i =0;i<array.length;i++) {
            sum += array[i];

            if (hashMap.containsKey(sum)) {
                List<Integer> list = hashMap.get(sum);
                for (Integer x : list) {
                    System.out.println("Sub-array[" + (x + 1) + ".." + i + "]");
                }
            }
            insertMap(hashMap,sum,i);
        }
    }

    public static void main(String[] args) {
        int[] x = {3, 4, -7, 3, 1, 3, 1, -4, -2, -2};
        resolveArray(x);
    }

}