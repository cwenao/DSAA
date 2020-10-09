/**
 * Company Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.java.synchronization;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id ReentrantLockDemo.java, v1.0.0 2020-07-21 14:35 cwenao Exp $$
 */
public class ReentrantLockDemo {

    private Lock lock = new ReentrantLock(false);

    private Condition condition = lock.newCondition();

    private ReentrantLockWaitTest reentrantLockWaitTest;

    private ReetrantLockSignalTest reetrantLockSignalTest;


    ReentrantLockDemo(){
        this.reentrantLockWaitTest = new ReentrantLockWaitTest();
        this.reetrantLockSignalTest = new ReetrantLockSignalTest();
    }

    class ReentrantLockWaitTest extends Thread {


        public void run() {

            try {
                lock.lock();

                System.out.println("waiting begin ... ");
                condition.await();

                System.out.println("waiting end ...");

                System.out
                        .println("waiting thread's name is: " + Thread.currentThread().getName() + " ");

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }

    class ReetrantLockSignalTest extends Thread {
        public void run() {
            try {
                lock.lock();
                System.out
                        .println("signal... and the thread name is :" + Thread.currentThread().getName());
                condition.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {

        ReentrantLockDemo reentrantLockDemo = new ReentrantLockDemo();

        reentrantLockDemo.reentrantLockWaitTest.start();
        reentrantLockDemo.reetrantLockSignalTest.start();

    }


}
