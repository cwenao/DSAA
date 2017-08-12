/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure.graph;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author cwenao
 * @version $Id Graph.java, v 0.1 2017-08-12 15:06 cwenao Exp $$
 */
public class Graph<T extends Comparable> {

    private static final Logger LOG = LoggerFactory.getLogger(Graph.class);

    private final int V; // the number of Vertex

    private int E; //the number of edge

    private Bag<Integer>[] adj; // the array of adjacency list

    public Graph(int V) {
        if (0 > V)
            throw new IllegalArgumentException();
        this.V = V;
        this.E = 0;
        adj = new Bag[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<Integer>();
        }
    }

    /**
     * add the vertex and add the edge number
     * @param v
     * @param w
     */
    public void addEdge(int v, int w) {
        checkedVertex(v);
        checkedVertex(w);
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }

    /**
     * to traverse the adjacency
     * @param v
     * @return
     */
    public Iterable<Integer> adj(int v) {
        checkedVertex(v);
        return adj[v];
    }

    /**
     * to return the bag of degree
     * @param v
     * @return
     */
    public int degree(int v) {
        checkedVertex(v);
        return adj[v].size();
    }

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }


    private void checkedVertex(int v) {
        if (v < 0 || v > V) {
            throw new IllegalArgumentException();
        }
    }

}
