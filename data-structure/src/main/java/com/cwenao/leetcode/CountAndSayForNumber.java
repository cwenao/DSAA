/**
 * Company Copyright (C) 2014-2019 All Rights Reserved.
 */
package com.cwenao.leetcode;

/**
 *
 * TODO : Statement the class description
 * @author cwenao
 * @version $Id CountAndSayForNumber.java, v1.0.0 2019-09-26 14:03 cwenao Exp $$
 */
public class CountAndSayForNumber {

    public String countAndSay(int n) {

        StringBuffer result = new StringBuffer();

        String current = "1";
        int count = 1;

        for (int i = 0; i < n; i++) {

            if (i == n - 1) {
                return current;
            }

            while (current !=null && !current.equals("")) {

                String tmp = current.substring(1);

                String tmpForMoreThan = current.substring(0,1);

                if (!"".equals(tmp) && tmpForMoreThan.equals(tmp.substring(0,1))) {
                    count++;
                } else {
                    result.append(count).append(tmpForMoreThan);
                    count = 1;
                }
                current = current.substring(1);
            }
            current = result.toString();
            result = new StringBuffer("");
        }
        return current;
    }


    public static void main(String[] args) {
        CountAndSayForNumber countAndSayForNumber = new CountAndSayForNumber();
        System.out.println(countAndSayForNumber.countAndSay(5));
    }

}
