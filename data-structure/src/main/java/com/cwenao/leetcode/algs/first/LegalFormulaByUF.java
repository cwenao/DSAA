/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id LegalFormulaByUF.java, v1.0.0 2021-01-01 09:35 cwenao Exp $$
 */
public class LegalFormulaByUF {

    public boolean legalFormula(String[] equations) {
        //创建26字母
        UnionFind unionFind = new UnionFind(26);

        //创建并查集连通分量
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                char left = equation.charAt(0);
                char right = equation.charAt(3);
                unionFind.union(left - 'a', right - 'a');
            }
        }

        //检测!= 是否破坏连通分量
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                char left = equation.charAt(0);
                char right = equation.charAt(1);
                if (unionFind.connected(left - 'a', right - 'a')) {
                    return false;
                }
            }
        }

        return true;
    }

}
