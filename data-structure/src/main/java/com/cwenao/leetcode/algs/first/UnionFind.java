/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id UnionFind.java, v1.0.0 2020-12-30 22:08 cwenao Exp $$
 */
public class UnionFind {

    //连通分量
    private int count;

    //节点X的父节点
    private int[] parent;

    //树大小
    private int[] size;

    public UnionFind(int n) {
        this.count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = i;
        }
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count--;
    }

    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }
    private int find(int value) {
        while (parent[value] != value) {
            //压缩路径,将不同节点点指向同一个父节点
            parent[value] = parent[parent[value]];
            value = parent[value];
        }

        return value;
    }

}
