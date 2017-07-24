/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying.array;

/**
 * @author cwenao
 * @version $Id MajorityElement.java, v 0.1 2017-07-17 9:15 cwenao Exp $$
 */
public class MajorityElement {

    private int searchMajority(int[] majArray, int size) {
        int majIndex = 0;
        int count = 1;

        for(int i =1;i<size;i++) {
            if (majArray[majIndex] == majArray[i]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                majIndex = i;
                count = 1;
            }
        }

        return majArray[majIndex];
    }

    private boolean isMajority(int[] majArray, int size, int maj) {
        int count = 0;
        for (int i=0;i<size;i++) {
            if (maj == majArray[i]) {
                count++;
            }
        }
        if (count >= size / 2) {
            return true;
        }
        return false;
    }

    private void printMajority(int[] majArray, int size) {
        int maj = searchMajority(majArray, size);
        if (isMajority(majArray, size, maj)) {
            System.out.println("The majority element is : " + maj);
        } else {
            System.out.println("Have no majority element  ");
        }
    }

    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();

        int[] majArray = {4, 3, 4, 5, 4, 3, 4, 7, 4, 8, 4};
        int size = majArray.length;
        majorityElement.printMajority(majArray, size);
    }

}

