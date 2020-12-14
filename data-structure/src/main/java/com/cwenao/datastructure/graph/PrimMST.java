/*
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure.graph;

import com.cwenao.datastructure.queue.IndexMinPQ;

import java.util.ArrayDeque;
import java.util.Queue;

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


    public PrimMST(EdgeWeightGraph graph) {
        edgeTo = new Edge[graph.getV()];
        distTo = new double[graph.getV()];
        marked = new boolean[graph.getV()];

        pq = new IndexMinPQ<>(graph.getV());

        for (int v = 0; v < graph.getV(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        for (int v = 0; v < graph.getV(); v++) {
            if (!marked[v]) {
                scan(graph, v);
            }
        }
    }

    private void prim(EdgeWeightGraph graph, int s) {
        distTo[s] = 0.0;
        pq.insert(s, distTo[s]);
        while (!pq.isEmpty()) {
            int v = pq.delMin();
            scan(graph, v);
        }
    }

    private void scan(EdgeWeightGraph edgeWeightGraph, int v) {
        marked[v] = true;
        for (Edge edge : edgeWeightGraph.adj(v)) {
            int w = edge.getOther(v);
            if (marked[w]) {
                continue;
            }
            if (edge.getWeight() < distTo[w]) {
                distTo[w] = edge.getWeight();
                edgeTo[w] = edge;
                if (pq.contains(w)) {
                    pq.decreaseKey(w, distTo[w]);
                } else {
                    pq.insert(w, distTo[w]);
                }
            }
        }
    }

    public Iterable<Edge> edges() {
        Queue<Edge> edges = new ArrayDeque<>();

        for (int v = 0; v < edgeTo.length; v++) {
            Edge edge = edgeTo[v];
            if (edge!=null) {
                edges.offer(edge);
            }
        }
        return edges;
    }

}
