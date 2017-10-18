/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure.graph;

import com.cwenao.datastructure.queue.IndexMinPQ;

import java.util.Stack;

/**
 * 单源最短路径：求边上的最小权
 * （1）设立U 和Y两个节点集合， Y用于保存所有未被访问的节点，U 记录所有已经访问过的节点。
 * 已经被访问指的是节点已经被纳入最短路径中。
 * （2）从Y中找出距离起点最近的节点，放入U中，并更新与这个节点有边直接相连的相邻节点到起始节点的最短距离。
 * （3）重复步骤（2）直到Y集合为空，即从起点出发可以到达的所有顶点都在集合U中为止。
 * 松弛：重新确定中心点
 * @author cwenao
 *
 * @version $Id DijkstraShortPath.java, v 0.1 2017-08-22 23:24 cwenao Exp $$
 */

public class DijkstraShortPath{

    private Double[] distTo;

    private DirectedEdge[] directedEdge;

    private IndexMinPQ<Double> indexMinPQ;

    public DijkstraShortPath(DirectedAndEdgeWeightGraph graph, int s) {

        distTo = new Double[graph.getV()];
        directedEdge = new DirectedEdge[graph.getV()];

        for (int v =0;v<graph.getV();v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }

        distTo[s] = 0.0;

        indexMinPQ = new IndexMinPQ<>(graph.getV());
        indexMinPQ.insert(s, distTo[s]);

        while (!indexMinPQ.isEmpty()) {
            int v = indexMinPQ.delMin();
            for (DirectedEdge e : graph.adj(v)) {
                relaxation(e);
            }
        }
    }

    /**
     * 松弛
     * @param edge
     */
    private void relaxation(DirectedEdge edge) {
        int source = edge.getVertexFrom();
        int target = edge.getVertexTo();
        //判断 最短路径
        if (distTo[target] > distTo[source] + edge.getWeight()) {
            distTo[target] = distTo[source] + edge.getWeight();
            //重新定位中心点
            directedEdge[target] = edge;
            if (indexMinPQ.contains(target)) {
                indexMinPQ.decreaseKey(target, distTo[target]);
            } else {
                indexMinPQ.insert(target,distTo[target]);
            }
        }
    }

    public double distTo(int v) {
        return distTo[v];
    }

    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<DirectedEdge> path = new Stack<>();
        for (DirectedEdge edge = directedEdge[v]; edge != null; edge = directedEdge[edge.getVertexFrom()]) {
            path.push(edge);
        }
        return path;
    }
}
