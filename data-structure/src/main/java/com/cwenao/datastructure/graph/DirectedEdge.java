/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure.graph;

/**
 * 有向边且带权重集合
 * @author cwenao
 * @version $Id DirectedEdge.java, v 0.1 2017-08-25 08:30 cwenao Exp $$
 */
public class DirectedEdge {
    private final int vertexFrom;
    private final int vertexTo;
    private final double weight;


    public DirectedEdge(int vertexFrom, int vertexTo, double weight) {

        this.vertexFrom = vertexFrom;
        this.vertexTo = vertexTo;
        this.weight = weight;
    }

    public int getVertexFrom() {
        return vertexFrom;
    }

    public int getVertexTo() {
        return vertexTo;
    }

    public double getWeight() {
        return weight;
    }

}
