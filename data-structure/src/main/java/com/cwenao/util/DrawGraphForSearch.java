/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.util;

/**
 * @author cwenao
 * @version $Id DrawGraphForSearch.java, v 0.1 2017-07-05 8:36 cwenao Exp $$
 */
public class DrawGraphForSearch {

    private Vertexes[] vertexes;
    private int[][] adjacent;

    private int vertexNum;

    public DrawGraphForSearch() {

    }

    /**
     * 初始化
     * @param vertexNum
     */
    public DrawGraphForSearch(int vertexNum) {
        this.vertexNum = vertexNum;
        vertexes = new Vertexes[vertexNum];
        adjacent = new int[vertexNum][vertexNum];

        for(int i =0 ;i<vertexNum;i++) {
            for (int j=0;j<vertexNum;j++) {
                adjacent[i][j] = 0;
            }
        }
    }

    /**
     * 添加边，因为无向图所以这正反都是可以
     * @param start
     * @param end
     */
    public void addEdge(int start, int end) {
        adjacent[start][end] = 1;
        adjacent[end][start] = 1;
    }


    /**
     * Getter method for property <tt>vertexes</tt>.
     *
     * @return property value of vertexes
     */

    public Vertexes[] getVertexes() {
        return vertexes;
    }

    /**
     * Setter method for property <tt>vertexes</tt>.
     *
     * @param vertexes value to be assigned to property vertexes
     */
    public void setVertexes(Vertexes[] vertexes) {
        this.vertexes = vertexes;
    }

    /**
     * Getter method for property <tt>adjacent</tt>.
     *
     * @return property value of adjacent
     */

    public int[][] getAdjacent() {
        return adjacent;
    }

    /**
     * Setter method for property <tt>adjacent</tt>.
     *
     * @param adjacent value to be assigned to property adjacent
     */
    public void setAdjacent(int[][] adjacent) {
        this.adjacent = adjacent;
    }

    /**
     * Getter method for property <tt>vertexNum</tt>.
     *
     * @return property value of vertexNum
     */

    public int getVertexNum() {
        return vertexNum;
    }

    /**
     * Setter method for property <tt>vertexNum</tt>.
     *
     * @param vertexNum value to be assigned to property vertexNum
     */
    public void setVertexNum(int vertexNum) {
        this.vertexNum = vertexNum;
    }

}

