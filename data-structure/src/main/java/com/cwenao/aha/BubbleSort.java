/**
 * Company Copyright (C) 2014-2019 All Rights Reserved.
 */
package com.cwenao.aha;

/**
 *
 * TODO : Statement the class description
 * @author cwenao
 * @version $Id BubbleSort.java, v1.0.0 2019-07-02 06:34 cwenao Exp $$
 */
public class BubbleSort {

    public static void  bubbleSort(int source[]) {

        if (source == null || source.length == 0) {
            return;
        }

        for (int i = 1; i < source.length; i++) {
            for (int x = 0; x < source.length - i; x++) {
                int tmp = source[x];
                if (source[x] < source[x + 1]) {
                    source[x] = source[x + 1];
                    source[x + 1] = tmp;
                }
            }
        }

    }

    public static void main(String[] args) {
        int test[] = new int[]{1,9,4,3,50,25};
        bubbleSort(test);
        for (int i = 0; i <test.length ; i++) {
            System.out.println(test[i]);
        }
    }

}
