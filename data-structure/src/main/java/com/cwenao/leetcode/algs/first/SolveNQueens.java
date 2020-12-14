/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id SolveNQueens.java, v1.0.0 2020-12-11 13:51 cwenao Exp $$
 */
public class SolveNQueens {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];

        for (char[] border : board) {
            Arrays.fill(border, '.');
        }

        solveNQueens(result, board, 0);

        return result;
    }

    private void solveNQueens(List<List<String>> result, char[][] board, int row) {

        if (row == board.length) {
            result.add(generateNQueens(board));
            return;
        }

        for (int col = 0; col < board[row].length; col++) {
            if (!isValid(board, row, col)) {
                continue;
            }
            board[row][col] = 'Q';
            solveNQueens(result, board, row + 1);
            board[row][col] = '.';
        }

    }

    private boolean isValid(char[][] board, int row, int col) {

        int border = board.length;

        for (int i = 0; i < border; i++) {
            if (((int) ('Q')) == ((int) (board[i][col]))) {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >=0; i--, j--) {
            if (((int) ('Q')) == ((int) (board[i][j]))) {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < border; i--, j++) {
            if (((int) ('Q')) == ((int) (board[i][j]))) {
                return false;
            }
        }

        return true;
    }

    private List<String> generateNQueens(char[][] board) {
        List<String> res = new ArrayList<>(board.length);
        for (char[] row : board) {
            res.add(new String(row));
        }
        return res;
    }

    public static void main(String[] args) {
        SolveNQueens solveNQueens = new SolveNQueens();
        List<List<String>> result = solveNQueens.solveNQueens(4);
        for (List<String> rowList : result) {
            for (String row : rowList) {
                System.out.println(row);
            }
        }
    }

}
