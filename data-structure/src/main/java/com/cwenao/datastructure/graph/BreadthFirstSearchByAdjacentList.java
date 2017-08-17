/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure.graph;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 基于队列完成广度优先搜索
 * @author cwenao
 * @version $Id BreadthFirstSearchByAdjacentList.java, v 0.1 2017-08-16 18:57 cwenao Exp $$
 */
public class BreadthFirstSearchByAdjacentList<T extends Comparable> {
    private boolean[] marked;
    private int count;
    private Graph<Integer> graph;
    private int data;

    public BreadthFirstSearchByAdjacentList(Graph<Integer> graph, int data) {
        marked = new boolean[graph.getV()];
        this.data = data;
        this.graph = graph;
        count = 0;
    }

    /**
     * 基于队列实现广度优先
     * 将遍历的顶点的子节点放入队列
     * 这样可以保证在同节点被遍历完成后遍历子节点
     */
    public void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(data);

        while (!queue.isEmpty()) {
            int x = queue.poll();
            marked[x] = true;
            //System.out.println("this is marked the point: "+ x);
            for (int w : graph.adj(x)) {
                if (!isMarked(w)) {
                    marked[w] = true;
                    queue.offer(w);
                    System.out.println("this is marked the point: "+ w);
                }
            }
        }
    }

    private boolean isMarked(int v) {
        checkedVertex(v);
        return marked[v];
    }

    private void checkedVertex(int v) {
        if (v > marked.length || v < 0) {
            throw new IllegalArgumentException("the vertex must between 0 and  " + (marked.length - 1));
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

        BreadthFirstSearchByAdjacentList bfs = new BreadthFirstSearchByAdjacentList(graph, 0);

        bfs.bfs();

    }

}
