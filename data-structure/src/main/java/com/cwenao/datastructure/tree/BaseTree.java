/*
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure.tree;

/**
 * @author cwenao
 * @version $Id BaseTree.java, v 0.1 2017-07-27 23:55 cwenao Exp $$
 */
public interface BaseTree<T extends Comparable> {

    int size();

    boolean contains(T data);

    void insert(T data);

    void remove(T data);

    int height();

    BinaryNode<T> findExcludeLeftNode(BinaryNode<T> node);

    BinaryNode<T> findExcludeRightNode(BinaryNode<T> node);

    BinaryNode<T> findNode(T data);
}
