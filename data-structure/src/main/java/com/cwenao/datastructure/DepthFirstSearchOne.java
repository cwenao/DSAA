/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure;

import com.cwenao.util.DrawGraphForSearch;
import com.cwenao.util.Vertexes;

/**
 * 深度优先遍历搜索
 * @author cwenao
 * @version $Id DepthFirstSearchOne.java, v 0.1 2017-07-05 8:35 cwenao Exp $$
 */
public class DepthFirstSearchOne {

    private static Vertexes[] vertexes;
    private static int[][] adjacent;

    private static final int maxVertexes = 9;

    /**
     * 遍历入口
     */
    public static void DFSOneTraverse() {
        for(int i =0; i<maxVertexes;i++) {
            if (vertexes[i].getVisited() == false) {
                traverse(i);
            }
        }
    }

    /**
     * 递归遍历
     * @param i
     */
    private static void traverse(int i) {
        vertexes[i].setVisited(true);

        printVertexe(i);

        for(int j =0;j<maxVertexes;j++) {
            if (adjacent[i][j] == 1 && vertexes[j].getVisited() == false) {
                traverse(j);
            }
        }
    }

    private static void printVertexe(int i) {
        System.out.println(vertexes[i].getVertex() + " ");
    }

    public static void main(String[] args) {
        DrawGraphForSearch drawGraphForSearch = new DrawGraphForSearch(maxVertexes);

        char[] ver = {'A','B','C','D','E','F','G','H','I'};

        vertexes = drawGraphForSearch.getVertexes();

        for(int i=0;i<vertexes.length;i++) {
            Vertexes vertexesX = new Vertexes(ver[i]);
            vertexes[i] = vertexesX;
        }

        drawGraphForSearch.setVertexes(vertexes);
        adjacent = drawGraphForSearch.getAdjacent();
        DFSOneTraverse();
    }

}

