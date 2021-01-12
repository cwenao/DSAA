/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id Combine.java, v1.0.0 2021-01-12 09:42 cwenao Exp $$
 */
public class Combine {

    private LinkedList<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> track = new LinkedList<>();
        combineByBacktracking(n, k, 1, track);
        return result;
    }

    private void combineByBacktracking(int n, int k, int start, LinkedList<Integer> track) {

        if (k == track.size()) {
            result.add(new ArrayList<>(track));
            return;
        }

        for (int i = start; i <= n; i++) {
            track.add(i);
            combineByBacktracking(n, k, i + 1, track);
            track.removeLast();
        }

    }

}
