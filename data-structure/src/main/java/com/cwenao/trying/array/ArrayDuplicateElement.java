/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying.array;

/**
 * @author cwenao
 * @version $Id ArrayDuplicateElement.java, v 0.1 2017-07-02 12:02 cwenao Exp $$
 */
public class ArrayDuplicateElement {

    /**
     * 利用按位运算，限制 必须>=0
     * @param arrays
     * @return
     */
    private static int findDuplicateElementByXOR(int[] arrays) {

        int len = arrays.length;

        int duplicateElement = 0;

        for (int i =0; i< len; i++) {
            duplicateElement ^= arrays[i];
        }

        for (int i =1; i< len; i++) {
            duplicateElement ^= i;
        }

        return duplicateElement;
    }

    /**
     * 利用桶排序，同样限制>=0,知道最大值
     * @param arrays
     * @param maxNum
     */
    private static void findDuplicateElementByBucketSorte(int[] arrays,int maxNum) {
        int len = arrays.length;
        int[] duplicateArray = new int[maxNum+1];

        for(int i =0;i<len;i++) {
            duplicateArray[arrays[i]] += 1;
        }

        for (int i =0;i<duplicateArray.length;i++) {
            if (duplicateArray[i] > 1) {
                System.out.println("The duplicate element " +i);
            }
        }

    }

    public static void main(String[] args) {
        int[] arrays = {0, 1 ,3, 5, 10, 10};
        System.out.println("Dulicate element is " + findDuplicateElementByXOR(arrays));

        findDuplicateElementByBucketSorte(arrays,10);
    }
}

