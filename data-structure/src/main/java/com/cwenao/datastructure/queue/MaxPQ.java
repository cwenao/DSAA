/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure.queue;

/**
 * @author cwenao
 * @version $Id MaxPQ.java, v 0.1 2017-08-30 08:28 cwenao Exp $$
 */
public class MaxPQ<T extends Comparable<T>> {

    private T[] pq;
    private int len = 0;

    public MaxPQ() {
        this(20);
    }

    public MaxPQ(int len) {
        pq = (T[]) new Comparable[len + 1];
    }

    /**
     * 在末尾插入值，然后重新恢复有序
     * @param value
     */
    public void insert(T value) {
        pq[++len] = value;
        swim(len);
    }

    /**
     * 删除最大值，以下沉的方式重新有序
     * @return
     */
    public T delMax() {

        T max = pq[1]; //获取最大值
        exch(1, len--); //将最大值与最后一个进行交换
        pq[len + 1] = null;
        sink(1);
        return max;
    }

    /**
     * 判断大小
     * @param i
     * @param j
     * @return
     */
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    /**
     * 交换
     * @param i
     * @param j
     */
    private void exch(int i, int j) {
        T tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }

    /**
     * 上浮
     * @param k
     */
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    /**
     * 下沉，与子节点中较大的节点交换
     * @param k
     */
    private void sink(int k) {
        while (2 * k <= len) {

            int nextK = 2 * k;

            //判断子节点的左右节点大小
            if (nextK < len && less(nextK, nextK + 1)) {
                nextK++;
            }
            if (!less(k, nextK)) {
                break;
            }
            //交换下沉
            exch(k, nextK);
            k = nextK;
        }
    }

    public int size() {
        return len;
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public static void main(String[] args) {
        MaxPQ<Integer> maxPQ = new MaxPQ<>();
        maxPQ.insert(10);
        maxPQ.insert(2);
        maxPQ.insert(3);
        maxPQ.insert(20);

        System.out.println(maxPQ.size());

    }
}
