/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure.graph;

import com.cwenao.datastructure.queue.IndexMinPQ;

/**
 * 图G，顶点集合为U，设集合空集合V，边集合UV，
 * 1.从U中选取顶点a为起始点，将a加入V，将a从U中删除
 * 2.以a为起点在集合UV中找到一点b使得a到b的权值最小
 * 3.将b加入V，将b从U中删除
 * 4.重复2、3直到U为空
 * @author cwenao
 * @version $Id PrimMST.java, v 0.1 2017-09-10 17:36 cwenao Exp $$
 */
public class PrimMST {
    private Edge[] edgeTo;
    private double[] distTo;
    private boolean[] marked;
    private IndexMinPQ<Double> pq;


    private void scan(EdgeWeightGraph edgeWeightGraph) {

    }

}
