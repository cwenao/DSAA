/**
 * Company Copyright (C) 2014-2019 All Rights Reserved.
 */
package com.cwenao.leetcode;

/**
 *
 * TODO : Statement the class description
 * @author cwenao
 * @version $Id ReverseNum.java, v1.0.0 2019-02-20 20:45 cwenao Exp $$
 */
public class ReverseNum {

    public static int reverse(int x) {
        Long result =0L;
        while (x != 0) {
            int reverse = x % 10;
            x= x/10;

            result = result * 10 + reverse;
            if (result>>31>0 || result>>31<-1){
                return 0;
            }
        }
        return result.intValue();
    }

    public static void main(String args[]){
        System.out.println(reverse(-21474));
        System.out.println(2<<30);
    }

}
