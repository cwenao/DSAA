/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying.graph;

import java.util.Stack;

/**
 * @author cwenao
 * @version $Id DepthFirstSearchTrying.java, v 0.1 2017-10-11 13:33 cwenao Exp $$
 */
public class DepthFirstSearchTrying {

    private boolean[] marked;
    private GraphTrying<Integer> graphTrying;
    private int v;

    public DepthFirstSearchTrying(GraphTrying graphTrying, int v) {
        this.graphTrying = graphTrying;
        marked = new boolean[graphTrying.getV()];
        this.v = v;
    }

    public void dfsWithStack(int v) {
        Stack<Integer> dfsStack = new Stack<>();
        dfsStack.push(v);
        marked[v] = true;
        while (!dfsStack.isEmpty()) {
            int x = dfsStack.peek();
            dfsStack.pop();

            System.out.println("this is the x: " + x);
            for (Integer w : graphTrying.adj(x)) {
                if (!marked[w]) {
                    System.out.println("this is the w: " + w);
                    dfsStack.push(w);
                    marked[w] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphTrying<Integer> graphTrying = new GraphTrying<>(7);
        graphTrying.addEdge(0, 1);
        graphTrying.addEdge(0, 2);
        graphTrying.addEdge(1, 4);
        graphTrying.addEdge(2, 3);
        graphTrying.addEdge(4, 6);

        DepthFirstSearchTrying depthFirstSearchTrying = new DepthFirstSearchTrying(graphTrying, 0);
        depthFirstSearchTrying.dfsWithStack(0);



    }
}
