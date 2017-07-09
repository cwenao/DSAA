/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.util;

/**
 * @author cwenao
 * @version $Id DrawGraphEdge.java, v 0.1 2017-07-09 9:08 cwenao Exp $$
 */
public class DrawGraphEdge {

    private DrawGraphNode leftNode;
    private DrawGraphNode rightNode;

    public DrawGraphEdge(DrawGraphNode leftNode, DrawGraphNode rightNode) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    /**
     * Getter method for property <tt>leftNode</tt>.
     *
     * @return property value of leftNode
     */

    public DrawGraphNode getLeftNode() {
        return leftNode;
    }

    /**
     * Getter method for property <tt>rightNode</tt>.
     *
     * @return property value of rightNode
     */

    public DrawGraphNode getRightNode() {
        return rightNode;
    }
}

