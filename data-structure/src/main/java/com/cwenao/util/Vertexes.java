/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.util;

/**
 * @author cwenao
 * @version $Id Vertexes.java, v 0.1 2017-07-05 8:39 cwenao Exp $$
 */
public class Vertexes {

    private char vertex;
    private Boolean visited;

    public Vertexes(char vertex) {
        this.vertex = vertex;
        this.visited = false;
    }

    /**
     * Getter method for property <tt>vertex</tt>.
     *
     * @return property value of vertex
     */

    public char getVertex() {
        return vertex;
    }

    /**
     * Setter method for property <tt>vertex</tt>.
     *
     * @param vertex value to be assigned to property vertex
     */
    public void setVertex(char vertex) {
        this.vertex = vertex;
    }

    /**
     * Getter method for property <tt>isVisited</tt>.
     *
     * @return property value of isVisited
     */

    /**
     * Getter method for property <tt>visited</tt>.
     *
     * @return property value of visited
     */

    public Boolean getVisited() {
        return visited;
    }

    /**
     * Setter method for property <tt>visited</tt>.
     *
     * @param visited value to be assigned to property visited
     */
    public void setVisited(Boolean visited) {
        this.visited = visited;
    }
}

