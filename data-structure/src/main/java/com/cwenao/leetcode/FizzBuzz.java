/**
 * Company Copyright (C) 2014-2019 All Rights Reserved.
 */
package com.cwenao.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 *
 * #412 Fizz Buzz
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 * @author cwenao
 * @version $Id FizzBuzz.java, v1.0.0 2019-07-26 14:20 cwenao Exp $$
 */
public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        String fizz = "Fizz";
        String buzz = "Buzz";
        String fizzBuzz = fizz + buzz;
        int fizzArray[] = IntStream.range(1, n+1).toArray();
        List<String> result = new ArrayList<>(n);

        for (int x : fizzArray) {

            if (x % 3 == 0 && x % 5 == 0) {
                result.add(fizzBuzz);
                continue;
            }
            if (x % 3 == 0) {
                result.add(fizz);
                continue;
            }
            if (x % 5 == 0) {
                result.add(buzz);
                continue;
            }
            result.add(String.valueOf(x));
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 15;
        FizzBuzz fizzBuzz = new FizzBuzz();
        List<String> test = fizzBuzz.fizzBuzz(n);
        test.stream().forEach(x -> System.out.println(x));
    }

}
