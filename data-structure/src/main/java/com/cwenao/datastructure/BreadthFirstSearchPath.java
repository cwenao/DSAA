/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure;

import com.cwenao.util.DrawGraphForSearch;
import com.cwenao.util.Vertexes;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author cwenao
 * @version $Id BreadthFirstSearchPath.java, v 0.1 2017-07-07 8:17 cwenao Exp $$
 */
public class BreadthFirstSearchPath {

    private static final int maxVertexes = 5;
    private static Vertexes[] vertexes;
    private static int[][] adjacent;

    public static void entrySearar (Integer start) {
        Queue queue = new ArrayDeque();
        queue.add(start);

        while (!queue.isEmpty()) {
            int x = (int) queue.poll();
            printVertexe(x);
            for(int i =1;i<maxVertexes;i++) {
                if (adjacent[x][i] != 1 && vertexes[x].getVisited() == false) {
                    vertexes[x].setVisited(true);
                    queue.offer(i);
                }
            }
        }
    }

    private static void printVertexe(int i) {
        System.out.println(vertexes[i].getVertex() + " ");
    }
    public static void main(String[] args) {
        DrawGraphForSearch drawGraphForSearch = new DrawGraphForSearch(maxVertexes);

        char[] ver = {'A','B','C','D','E'}; //,'D','E','F','G','H','I'

        vertexes = drawGraphForSearch.getVertexes();

        for(int i=0;i<vertexes.length;i++) {
            Vertexes vertexesX = new Vertexes(ver[i]);
            vertexes[i] = vertexesX;
        }
        drawGraphForSearch.addEdge(0,1);
        drawGraphForSearch.addEdge(0,2);
        drawGraphForSearch.addEdge(2,3);
        drawGraphForSearch.addEdge(3,5);
        drawGraphForSearch.addEdge(5,8);

        drawGraphForSearch.setVertexes(vertexes);
        adjacent = drawGraphForSearch.getAdjacent();
        entrySearar(0);

    }
}

