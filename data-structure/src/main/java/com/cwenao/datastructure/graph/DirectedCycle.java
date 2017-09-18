/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure.graph;

import java.util.Stack;

/**
 *
 * @author cwenao
 * @version $Id DirectedCycle.java, v 0.1 2017-09-18 22:13 cwenao Exp $$
 */
public class DirectedCycle {
    private boolean[] marked;
    private int[] edgeTo;
    private boolean[] onStack;
    private Stack<Integer> cycle;

    public DirectedCycle(DirectedGraph graph) {
        marked = new boolean[graph.getV()];
        edgeTo = new int[graph.getV()];
        onStack = new boolean [graph.getV()];

        for (int v = 0; v < graph.getV(); v++) {
            if (!marked[v] && cycle == null) {
                dfs(graph, v);
            }
        }
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }

    private void dfs(DirectedGraph graph, int v) {
        marked[v] = true;
        onStack[v] = true;

        for (int w : graph.ajd(v)) {
            if (cycle !=null) {
                return;
            } else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(graph, w);
            } else if (onStack[w]) {
                cycle = new Stack<>();
                for (int i = v; i != w; i = edgeTo[i]) {
                    cycle.push(i);
                }
                cycle.push(w);
                cycle.push(v);
            }

        }
        onStack[v] = false;

    }

}
