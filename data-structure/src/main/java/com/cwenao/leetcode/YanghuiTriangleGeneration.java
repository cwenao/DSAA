/**
 * Company Copyright (C) 2014-2019 All Rights Reserved.
 */
package com.cwenao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * TODO : Statement the class description
 * @author cwenao
 * @version $Id YanghuiTriangleGeneration.java, v1.0.0 2019-07-10 09:08 cwenao Exp $$
 */
public class YanghuiTriangleGeneration {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows == 0) {
            return triangle;
        }
        List<Integer> topRow = new ArrayList<>(1);
        topRow.add(1);
        triangle.add(topRow);

        if (numRows == 1) {
            return triangle;
        }

        for (int i = 1; i < numRows; i++) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(1);
            List<Integer> preRow = triangle.get(i - 1);

            for (int j = 1; j < preRow.size(); j++) {
                tmp.add(preRow.get(j-1) + preRow.get(j));
            }
            tmp.add(1);

            triangle.add(tmp);
        }

        return triangle;
    }

    public static void main(String[] args) {
        YanghuiTriangleGeneration y = new YanghuiTriangleGeneration();
        List<List<Integer>> tmp = y.generate(5);
        System.out.println(tmp);
    }

}
