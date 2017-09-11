/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure.graph;

/**
 * @author cwenao
 * @version $Id Edge.java, v 0.1 2017-09-11 16:33 cwenao Exp $$
 */
public class Edge implements Comparable<Edge>{

    private final int v;
    private final int w;
    private final double weight;

    public Edge(int v, int w, int weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int getOther(int x) {
        if (x == v) {
            return w;
        } else if (x == w) {
            return v;
        }
        throw new IllegalArgumentException("Illegal end point");
    }

    @Override
    public int compareTo(Edge o) {
        return Double.compare(this.weight, o.getWeight());
    }

    public int getV() {
        return v;
    }

    public int getW() {
        return w;
    }

    public double getWeight() {
        return weight;
    }
}
