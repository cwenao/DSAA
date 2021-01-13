/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id GenerateParenthesis.java, v1.0.0 2021-01-12 11:19 cwenao Exp $$
 */
public class GenerateParenthesis {

    private List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return result;
        }
        LinkedList<String> tracks = new LinkedList<>();
        generateParenthesisByBacktracking(n, n, tracks);

        return result;
    }

    private void generateParenthesisByBacktracking(int left, int right, LinkedList<String> tracks) {

        if (left > right) {
            return;
        }
        if (left < 0 || right < 0) {
            return;
        }

        if (left == 0 && right ==0) {
            result.add(tracks.stream().map(Objects::toString).reduce("",String::concat));
        }

        tracks.add("(");
        generateParenthesisByBacktracking(left - 1, right, tracks);
        tracks.removeLast();

        tracks.add(")");
        generateParenthesisByBacktracking(left, right - 1, tracks);
        tracks.removeLast();
    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        List<String> list =  generateParenthesis.generateParenthesis(4);
        list.stream().forEach(s -> System.out.println(s));
    }

}
