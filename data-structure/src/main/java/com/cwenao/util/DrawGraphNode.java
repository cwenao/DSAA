/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cwenao
 * @version $Id DrawGraphNode.java, v 0.1 2017-07-09 9:03 cwenao Exp $$
 */
public class DrawGraphNode {

    private char node;

    private List<DrawGraphEdge> listEdge = null;

    public DrawGraphNode(char node) {
        this.node = node;
        if (listEdge == null) {
            listEdge = new ArrayList<>();
        }
    }

    public void addEdge(DrawGraphEdge drawGraphEdge) {
        listEdge.add(drawGraphEdge);
    }

    /**
     * Getter method for property <tt>node</tt>.
     *
     * @return property value of node
     */

    public char getNode() {
        return node;
    }

    /**
     * Getter method for property <tt>listEdge</tt>.
     *
     * @return property value of listEdge
     */

    public List<DrawGraphEdge> getListEdge() {
        return listEdge;
    }
}

