/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure.graph;

import java.util.Stack;

/**
 * @author cwenao
 * @version $Id EdgeWeightGraph.java, v 0.1 2017-09-12 16:45 cwenao Exp $$
 */
public class EdgeWeightGraph {
    private final int V;
    private int E;
    private Bag<Edge>[] adj;

    private EdgeWeightGraph(int v) {
        this.V = v;
        this.E = 0;
        adj = new Bag[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new Bag<>();
        }
    }

    private EdgeWeightGraph(EdgeWeightGraph graph) {
        this(graph.getV());
        this.E = graph.getE();

        for (int i = 0; i < graph.getV(); i++) {
            Stack<Edge> reverse = new Stack<>();

            for (Edge edge : graph.adj[i]) {
                reverse.push(edge);
            }
            for (Edge edge : reverse) {
                adj[i].add(edge);
            }
        }
    }

    public void addEdge(Edge edge) {
        int v = edge.getV();
        int w = edge.getOther(v);

        adj[v].add(edge);
        adj[w].add(edge);
        E++;
    }

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    public int degree(int v) {
        return adj[v].size();
    }
}
