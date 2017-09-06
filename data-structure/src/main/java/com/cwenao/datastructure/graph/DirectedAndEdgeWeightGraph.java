/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure.graph;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * 有向图且带权重
 * @author cwenao
 * @version $Id DirectedAndEdgeWeightGraph.java, v 0.1 2017-08-25 08:50 cwenao Exp $$
 */
public class DirectedAndEdgeWeightGraph {

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
        Random random = new Random(3);
        for(int i=0;i<E;i++) {

            int from = random.nextInt(V);
            int to = random.nextInt(V);
            double weight = Math.random() * 10;
            DirectedEdge directedEdge = new DirectedEdge(from, to, weight);
            addEdge(directedEdge);
        }

    }

    public void addEdge(DirectedEdge edge) {
        int from = edge.getVertexFrom();
        int to = edge.getVertexTo();

        adj[from].add(edge);
        indegree[to]++;
        E++;
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    public int outdegree(int v) {
        return adj[v].size();
    }

    public int indegree(int v) {
        return indegree[v];
    }

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }
}
