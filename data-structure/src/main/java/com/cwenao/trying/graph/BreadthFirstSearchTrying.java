/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying.graph;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author cwenao
 * @version $Id BreadthFirstSearchTrying.java, v 0.1 2017-10-13 15:39 cwenao Exp $$
 */
public class BreadthFirstSearchTrying {

    private boolean[] marked;
    private GraphTrying<Integer> graphTrying;
    private int v;

    public BreadthFirstSearchTrying(GraphTrying<Integer> graphTrying, int v) {
        this.graphTrying = graphTrying;
        this.v = v;
        marked = new boolean[graphTrying.getV()];
    }

    public void bfsWithQueue() {
        Queue<Integer> queue = new ArrayDeque();
        queue.add(v);
        marked[v] = true;

        while (!queue.isEmpty()) {

            int x = queue.poll();
            System.out.println("this is the x: " + x);
            for (Integer w : graphTrying.adj(x)) {
                if (!marked[w]) {
                    queue.offer(w);
                    marked[w] = true;
                    System.out.println("this is the w: " + w);
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphTrying<Integer> graphTrying = new GraphTrying<>(8);
        graphTrying.addEdge(0, 1);
        graphTrying.addEdge(0, 2);
        graphTrying.addEdge(1, 4);
        graphTrying.addEdge(2, 3);
        graphTrying.addEdge(2, 7);
        graphTrying.addEdge(4, 6);

        BreadthFirstSearchTrying breadthFirstSearchTrying = new BreadthFirstSearchTrying(graphTrying, 0);
        breadthFirstSearchTrying.bfsWithQueue();

    }

}
