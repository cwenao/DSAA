/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure.graph;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 有向图且带权重
 * @author cwenao
 * @version $Id DirectedAndEdgeWeightGraph.java, v 0.1 2017-08-25 08:50 cwenao Exp $$
 */
public class DirectedAndEdgeWeightGraph<T extends Comparable> {

    private static final Logger LOG = LoggerFactory.getLogger(DirectedAndEdgeWeightGraph.class);

    private int V;
    private int E;
    private Bag<DirectedEdge> adj;
    private int[] indegree;




}
