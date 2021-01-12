/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id SolveSudoku.java, v1.0.0 2021-01-12 10:16 cwenao Exp $$
 */
public class SolveSudoku {

    public void solveSudoku(char[][] board) {
        solveSudokuByBacktracking(board, 0, 0);
    }

    private boolean solveSudokuByBacktracking(char[][] board, int row, int col) {

        int m = 9, n = 9;
        //当前列遍历完成，则换行遍历
        if (col == n) {
            return solveSudokuByBacktracking(board, row + 1, 0);
        }
        //行遍历完成，则找到可行解
        if (row == m) {
            return true;
        }

        for (int i = row; i < m; i++) {
            for (int j = col; j < n; j++) {
                if (board[i][j] != '.') {
                    return solveSudokuByBacktracking(board, i, j + 1);
                }

                for (char k = '1'; k <= '9'; k++) {
                    if (!isValid(board, i, j, k)) {
                        continue;
                    }
                    board[i][j] = k;
                    if (solveSudokuByBacktracking(board, i, j + 1)) {
                        return true;
                    }
                    board[i][j] = '.';
                }
                return false;
            }
        }
        return false;
    }

    private boolean isValid(char[][] board, int row, int col, char k) {
        for (int l = 0; l < 9; l++) {
            if (board[row][l] == k) {
                return false;
            }
            if (board[l][col] == k) {
                return false;
            }
            //3*3 棋盘内判断是否有重复
            if (board[(row / 3) * 3 + l / 3][(col / 3) * 3 + l % 3] == k) {
                return false;
            }
        }
        return true;
    }

}
