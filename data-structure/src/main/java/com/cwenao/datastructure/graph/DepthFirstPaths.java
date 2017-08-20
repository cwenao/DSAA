/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure.graph;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Stack;

/**
 * @author cwenao
 * @version $Id DepthFirstPaths.java, v 0.1 2017-08-20 08:24 cwenao Exp $$
 */
public class DepthFirstPaths {
    
    private static final Logger LOG = LoggerFactory.getLogger(DepthFirstPaths.class);
    
    private boolean[] marked;
    private int[] edgeTo;

    private Graph<Integer> graph;
    private int source;

    public DepthFirstPaths(Graph<Integer> graph, int source) {
        marked = new boolean[graph.getV()];
        edgeTo = new int[graph.getV()];
        checkedVertex(source);
        this.graph = graph;
        this.source = source;
    }

    public void dfs() {
        dfs(graph,source);
    }

    private void dfs(Graph<Integer> graph, int source) {
        marked[source] = true;
        for (int w : graph.adj(source)) {
            if (!marked[w]) {
                edgeTo[w] = source;
                dfs(graph, w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        checkedVertex(v);
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        checkedVertex(v);
        if (!hasPathTo(v)) {
            return null;
        }

        Stack<Integer> stack = new Stack<>();
        for (int x = v; x !=source;x = edgeTo[x]) {
            stack.push(x);
        }
        stack.push(source);

        return stack;
    }

    private void checkedVertex(int v) {
        if (v < 0 || v > marked.length) {
            throw new IllegalArgumentException("the vertex is must between 0 and " + (marked.length - 1));
        }
    }

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(2, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);

        int source = 0;
        DepthFirstPaths depthFirstPaths = new DepthFirstPaths(graph, source);
        depthFirstPaths.dfs();

        for (int v=0;v<graph.getV();v++) {
            if (depthFirstPaths.hasPathTo(v)) {
                LOG.info("{} to {} : ", source, v);
                for (int x : depthFirstPaths.pathTo(v)) {
                    if (x == source) {
                        LOG.info("{}", x);
                    } else {
                        LOG.info("-{}", x);
                    }
                }
            }
        }
    }

}
