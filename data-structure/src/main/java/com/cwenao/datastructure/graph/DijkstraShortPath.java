/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure.graph;

/**
 * 单源最短路径：求边上的最小权
 * （1）设立U 和Y两个节点集合， Y用于保存所有未被访问的节点，U 记录所有已经访问过的节点。
 * 已经被访问指的是节点已经被纳入最短路径中。
 * （2）从Y中找出距离起点最近的节点，放入U中，并更新与这个节点有边直接相连的相邻节点到起始节点的最短距离。
 * （3）重复步骤（2）直到Y集合为空，即从起点出发可以到达的所有顶点都在集合U中为止。
 *
 * @author cwenao
 * @version $Id DijkstraShortPath.java, v 0.1 2017-08-22 23:24 cwenao Exp $$
 */
public class DijkstraShortPath<T extends Comparable> {

    private int[] distTo;

    private DirectedEdge[] directedEdge;


}
