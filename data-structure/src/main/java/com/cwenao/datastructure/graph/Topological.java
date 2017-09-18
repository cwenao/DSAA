/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure.graph;

/**
 * 拓扑排序为DAG所有顶点的线性排序
 * 1. 选择 DAG中入度为0（没有前驱）的顶点A，输出顶点A
 * 2. 删除以顶点A为起点的边
 * 3. 重复1、2步直到DAG顶点集合为空或者DAG中不存在入度为0的顶点
 *
 * @author cwenao
 * @version $Id Topological.java, v 0.1 2017-09-16 20:01 cwenao Exp $$
 */
public class Topological {

    private Iterable<Integer> order;
    private int[] rank;

    public Topological(DirectedGraph graph) {

    }

}
