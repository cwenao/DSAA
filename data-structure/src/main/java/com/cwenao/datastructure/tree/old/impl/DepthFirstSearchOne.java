/*
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure.tree.old.impl;

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

    private static final int MAX_VERTEXES = 9;

    /**
     * 遍历入口
     */
    public static void dfsOneTraverse() {
        for(int i =0; i<MAX_VERTEXES;i++) {
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

        for(int j =0;j<MAX_VERTEXES;j++) {
            if (adjacent[i][j] == 1 && vertexes[j].getVisited() == false) {
                printVertexe(j);
                traverse(j);
            }
        }
    }

    private static void printVertexe(int i) {
        System.out.println(vertexes[i].getVertex() + " ");
    }

    public static void printAdjacent(int[][] adjacent) {

        for(int[] line:adjacent) {
            for(int i:line) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        DrawGraphForSearch drawGraphForSearch = new DrawGraphForSearch(MAX_VERTEXES);

        char[] ver = {'A','B','C','D','E','F','G','H','I'};

        vertexes = drawGraphForSearch.getVertexes();

        for(int i=0;i<vertexes.length;i++) {
            Vertexes vertexesX = new Vertexes(ver[i]);
            vertexes[i] = vertexesX;
        }
        drawGraphForSearch.setVertexes(vertexes);

        drawGraphForSearch.addEdge(0,1);
        drawGraphForSearch.addEdge(0,2);
        drawGraphForSearch.addEdge(2,3);
        drawGraphForSearch.addEdge(3,5);
        drawGraphForSearch.addEdge(5,8);

        adjacent = drawGraphForSearch.getAdjacent();

        printAdjacent(adjacent);
        printVertexe(0);
        dfsOneTraverse();
    }
}

