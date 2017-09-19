/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure.graph;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @author cwenao
 * @version $Id DepthFirstOrder.java, v 0.1 2017-09-14 18:20 cwenao Exp $$
 */
public class DepthFirstOrder {
    private boolean[] marked;
    private int[] pre;
    private int[] post;

    private Queue<Integer> preOrder;
    private Queue<Integer> postOrder;

    private int preCounter;
    private int postCounter;

    public DepthFirstOrder(DirectedGraph graph) {
        pre = new int[graph.getV()];
        post = new int[graph.getV()];
        preOrder = new ArrayDeque<>();
        postOrder = new ArrayDeque<>();
        marked = new boolean[graph.getE()];

        for (int v = 0; v < graph.getV(); v++) {
            if (!marked[v]) {
                dfs(graph,v);
            }
        }

    }

    public Iterable<Integer> reversePost() {
        Stack<Integer> reverse = new Stack<>();
        for (int v : postOrder) {
            reverse.push(v);
        }
        return reverse;
    }

    private void dfs(DirectedGraph graph, int v) {
        marked[v] = true;
        pre[v] = preCounter++;
        preOrder.offer(v);

        for (int w : graph.ajd(v)) {
            if (!marked[w]) {
                dfs(graph, w);
            }
        }
        postOrder.offer(v);
        post[v] = postCounter++;
    }

    public int pre(int v) {
        return pre[v];
    }

    public int post(int v) {
        return post[v];
    }

    public Iterable<Integer> pre() {
        return preOrder;
    }

    public Iterable<Integer> post() {
        return postOrder;
    }
}
