/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.data.coding.multithreading;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id ThreadForkJoin.java, v1.0.0 2021-03-09 15:06 cwenao Exp $$
 */
public class ThreadForkJoin {

    class SumTask extends RecursiveTask<Long>{

        static final int THRESHOLD = 10;

        Long[] testArray;

        int start;

        int end;

        SumTask(Long[] testArray, Integer start, Integer end) {
            this.testArray = testArray;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {

            if ((end - start) <= THRESHOLD) {
                long sum = 0;
                for (int i = start; i < end; i++) {
                    sum += testArray[i];
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return sum;
            }

            int mid = (start + end) / 2;

            SumTask sumTask1 = new SumTask(this.testArray, start, mid);
            SumTask sumTask2 = new SumTask(this.testArray, mid, end);

            invokeAll(sumTask1,sumTask2);
            Long result1 = sumTask1.join();
            Long result2 = sumTask2.join();

            Long result = result1 + result2;

            System.out.println("result = " + result1 + " + " + result2 + " ==> " + result);

            return result;
        }
    }
    static Random random = new Random(0);

    static long random() {
        return random.nextInt(10000);
    }

    public Long counter(Long[] array, Integer start, Integer end) {
        ForkJoinTask<Long> forkJoinTask = new SumTask(array, start, end);
        return ForkJoinPool.commonPool().invoke(forkJoinTask);
    }

    public static void main(String[] args) {
        Long[] testArray = new Long[2000];
        long expectedSum = 0;

        for (int i = 0; i < 2000; i++) {
            testArray[i] = random();
            expectedSum += testArray[i];
        }
        System.out.println("Expected sum: " + expectedSum);

        ThreadForkJoin forkJoin = new ThreadForkJoin();
        System.out.println(forkJoin.counter(testArray, 0, testArray.length));
    }
}
