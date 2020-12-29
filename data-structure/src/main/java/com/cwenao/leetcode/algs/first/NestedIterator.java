/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id NestedIterator.java, v1.0.0 2020-12-29 07:13 cwenao Exp $$
 */
public class NestedIterator implements Iterator<Integer> {

    private LinkedList<NestedInteger> linkedList;

    public NestedIterator(List<NestedInteger> nestedList) {
        linkedList = new LinkedList<>(nestedList);
    }

    @Override
    public Integer next() {
        return linkedList.remove(0).getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!linkedList.isEmpty() && !linkedList.get(0).isInteger()) {
            List<NestedInteger> list = linkedList.remove(0).getList();
            //需要将展开后的list按倒序加入到linkedList中
            for (int i = list.size()-1; i >=0; i--) {
                linkedList.addFirst(list.get(i));
            }
        }
        return !linkedList.isEmpty();
    }

    class NestedInteger {

        private Integer value;

        private List<NestedInteger> list;

        public NestedInteger(Integer value) {
            this.value = value;
            this.list = null;
        }

        public NestedInteger(List<NestedInteger> list) {
            this.value = null;
            this.list = list;
        }

        public boolean isInteger() {
            return this.value != null;
        }

        public Integer getInteger() {
            return this.value;
        }

        public List<NestedInteger> getList() {
            return this.list;
        }

    }
}
