/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure.graph;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 有向图且带权重
 * @author cwenao
 * @version $Id DirectedAndEdgeWeightGraph.java, v 0.1 2017-08-25 08:50 cwenao Exp $$
 */
public class DirectedAndEdgeWeightGraph<T extends Comparable> {

    private static final Logger LOG = LoggerFactory.getLogger(DirectedAndEdgeWeightGraph.class);

    private int V; //the number of vertexes
    private int E; //the edge of with the vertexes
    private Bag<DirectedEdge>[] adj; //the adj for grap
    private int[] indegree; //this is the number for the edge

    public DirectedAndEdgeWeightGraph(int V) {
        this.V = V;
        this.E = 0;
        this.adj = new Bag[V];
        this.indegree = new int[V];
        for (int v=0;v<V;v++) {
            adj[v] = new Bag<>();
        }
    }


    public DirectedAndEdgeWeightGraph(int V, int E) {
        this(V);

    }

    public void addEdge(DirectedEdge edge) {
        int from = edge.getVertexFrom();
        int to = edge.getVertexTo();

        adj[from].add(edge);
        indegree[to]++;
        E++;
    }



}
