/**
 * Company Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode;

/**
 *
 * #10.01. 合并排序的数组
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 *
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 * 示例:
 *
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * @author cwenao
 * @version $Id MergeSortedArray.java, v1.0.0 2020-03-03 20:56 cwenao Exp $$
 */
public class MergeSortedArray {
    public void merge(int[] A, int m, int[] B, int n) {
        int idxA = m - 1;
        int idxB = n - 1;
        int site = m + n - 1;

        while (idxA > -1 || idxB > -1) {

            if (idxA == -1) {
                A[site] = B[idxB];
                idxB -= 1;
            } else if (idxB == -1) {
                A[site] = A[idxA];
                idxA -= 1;
            }else if (A[idxA] < B[idxB]) {
                A[site] = B[idxB];
                idxB -= 1;
            } else {
                A[site] = A[idxA];
                idxA -= 1;
            }
            site -= 1;
        }
    }

    public static void main(String[] args) {
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        int[] a = new int[]{1, 2, 3, 0, 0, 0};
        int[] b = new int[]{2, 5, 6};
        int m = 3;
        int n = 3;

        mergeSortedArray.merge(a,m,b,n);

        for (int i = 0; i <a.length ; i++) {
            System.out.println(a[i]);
        }

    }
}
