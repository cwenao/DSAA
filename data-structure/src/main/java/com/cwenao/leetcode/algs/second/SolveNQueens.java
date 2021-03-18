/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id SolveNQueens.java, v1.0.0 2021-03-18 09:14 cwenao Exp $$
 */
public class SolveNQueens {

    private  List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i],'.');
        }
        int row = 0;
        solveNQueensByBacktrack(board, row);

        return result;
    }

    private void solveNQueensByBacktrack(char[][] board, int row) {
        if (row == board.length) {
            result.add(generateNQueens(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (!isValid(board, row, col)) {
                continue;
            }

            board[row][col] = 'Q';
            solveNQueensByBacktrack(board, row + 1);
            board[row][col] = '.';
        }
    }

    private boolean isValid(char[][] board, int row, int col) {

        int len = board.length;
        //当前列是否已存在Q
        for (int i = 0; i < len; i++) {
            if ('Q' == board[i][col]) {
                return false;
            }
        }
        //左上位置
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if ('Q' == board[i][j]) {
                return false;
            }
        }

        //右上位置
        for (int i = row - 1, j = col + 1; i >= 0 && j < len; i--, j++) {
            if ('Q' == board[i][j]) {
                return false;
            }
        }

        return true;
    }

    private List<String> generateNQueens(char[][] board) {

        List<String> result = new ArrayList<>();
        for (char[] row : board) {
            result.add(new String(row));
        }
        return result;
    }

    public static void main(String[] args) {
        SolveNQueens solveNQueens = new SolveNQueens();
        solveNQueens.solveNQueens(8);
        for (List<String> rows : solveNQueens.result) {
            for (String row : rows) {
                System.out.println(row+" ");
            }
            System.out.println("");
        }
    }

}
