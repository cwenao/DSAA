/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id EnclosedArea.java, v1.0.0 2020-12-30 23:07 cwenao Exp $$
 */
public class EnclosedArea {

    public void solve(char[][] board) {
        solveByUnionFind(board);
    }

    private void solveByUnionFind(char[][] board) {
        if (board.length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;

        //构建并查集
        UnionFind unionFind = new UnionFind(m * n + 1);

        //虚拟公共节点，用于连通其他点
        //二维数组[m:n]映射一维数组[m*n+1]：node(x,y) = x*n+y
        int virtualRoot = m * n;
        //首列、末列连通
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                unionFind.union(i * n, virtualRoot);
            }
            if (board[i][n - 1] == 'O') {
                unionFind.union(i * n + n - 1, virtualRoot);
            }
        }
        //首行、末行连通
        for (int i = 0; i < m; i++) {
            if (board[0][i] == 'O') {
                unionFind.union(i, virtualRoot);
            }
            if (board[m - 1][i] == 'O') {
                unionFind.union(n * (m - 1) + i, virtualRoot);
            }
        }

        //定义当前'O'搜索方向:上下左右
        int[][] d = new int[][]{{1, 0}, {0, 1},{0, -1}, {-1, 0} };

        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O') {
                    for (int k = 0; k < 4; k++) {
                        //获取搜索方向上的坐标点
                        int x = i + d[k][0];
                        int y = j + d[k][1];

                        if (board[x][y] == 'O') {
                            unionFind.union(x * n + y, i * n + j);
                        }
                    }
                }
            }
        }

        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (!unionFind.connected(virtualRoot, i * n + j)) {
                    board[i][j] = 'X';
                }
            }
        }

    }

}
