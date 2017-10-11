/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying.graph;

/**
 * @author cwenao
 * @version $Id GraphTrying.java, v 0.1 2017-10-11 11:10 cwenao Exp $$
 */
public class GraphTrying<T extends Comparable> {
    private final int V;
    private int E;
    private BagTrying<Integer>[] adj;

    public GraphTrying(int v) {
        if (0>v) {
            throw new IllegalArgumentException();
        }
        this.V = v;
        this.E = 0;
        adj = new BagTrying[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new BagTrying<>();
        }
    }

    public void addEdge(int v, int w) {
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }

    public int degree(int v) {
        return adj[v].size();
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }
}
