/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure.graph;

import java.util.Stack;

/**
 * @author cwenao
 * @version $Id DirectedGraph.java, v 0.1 2017-09-09 15:16 cwenao Exp $$
 */
public class DirectedGraph {

    private final int V;
    private int E;
    private Bag<Integer>[] ajd;
    private int[] indegree;

    public DirectedGraph(int V) {
        this.V = V;
        this.E = 0;

        indegree = new int[V];
        ajd = new Bag[V];

        for (int v = 0; v < V; v++) {
            ajd[v] = new Bag<>();
        }
    }

    public DirectedGraph(DirectedGraph graph) {
        this(graph.getV());
        this.E = graph.getE();

        for (int v = 0; v < V; v++) {
            indegree[v] = graph.indegree(v);
        }
        for (int v=0;v<V;v++) {
            Stack<Integer> reverse = new Stack<>();
            for (int w : graph.ajd[v]) {
                reverse.push(w);
            }
            for (int w : reverse) {
                ajd[v].add(w);
            }
        }
    }

    public void addEdge(int v, int w) {
        ajd[v].add(w);
        indegree[w]++;
        E++;
    }

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }

    public Iterable<Integer> ajd(int v) {
        return ajd[v];
    }

    public int indegree(int v) {
        return indegree[v];
    }

    public int indegreeSize(int v) {
        return ajd[v].size();
    }
}
