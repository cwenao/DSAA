/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure.graph;

import java.util.Stack;

/**
 * 实现基于邻接表的深度优先搜索
 * @author cwenao
 * @version $Id DepthFirstSearchByAdjacentList.java, v 0.1 2017-08-13 08:43 cwenao Exp $$
 */
public class DepthFirstSearchByAdjacentList<T extends Comparable> {

    private boolean[] marked; //标识已经走过的路径

    private int count; //标识连接数量

    private Graph<Integer> graph; //输入图

    private int data; //需要查找的顶点

    public DepthFirstSearchByAdjacentList(Graph<Integer> graph,int data) {

        marked = new boolean[graph.getV()];
        checkedVertexs(data);
        this.graph = graph;
        this.data = data;
    }


    public void dfs() {
        dfs(graph, data);
    }

    /**
     * recursion the dfs
     * @param graph
     * @param v
     */
    private void dfs(Graph<Integer> graph, int v) {
        count++;
        marked[v] = true;
        for (int w : graph.adj(v)) {
            if (!isMarked(w)) {
                System.out.println("this is marked the point: "+ w);
                dfs(graph, w);
            }
        }
    }

    /**
     * 基于stack 实现迭代
     * @param graph
     * @param v
     */
    private void dfsWithStack(Graph<Integer> graph, int v) {
        Stack stack = new Stack();
        marked[v] = true;
        stack.push(v);
        System.out.println("this is  the root point: "+ v);
        while (v != -1) {
            for (int w : graph.adj(v)) {
                if (!isMarked(w)) {
                    System.out.println("this is marked the point: "+ w);
                    marked[w] = true;
                    stack.push(w);
                }
            }
            v = (int) stack.peek();
            stack.pop();
            if (stack.empty()) {
                v = -1;
            }
        }

    }

    public boolean isMarked(int v) {
        checkedVertexs(v);
        return marked[v];
    }

    public int getCount() {
        return count;
    }

    private void checkedVertexs(int v) {
        if (v < 0 || v > marked.length) {
            throw new IllegalArgumentException("vertex : " + v + "is not between 0 and " + (marked.length - 1));
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

        DepthFirstSearchByAdjacentList dfs = new DepthFirstSearchByAdjacentList(graph, 0);

//        dfs.dfs();
        dfs.dfsWithStack(graph, 0);
        for(int v = 0;v<graph.getV();v++) {
            if (dfs.isMarked(v)) {
                System.out.println("the vertex is : " +v);
            }
        }

    }

}
