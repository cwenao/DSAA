/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure.tree;

import java.io.Serializable;

/**
 * @author cwenao
 * @version $Id RBTSimpleImplement.java, v 0.1 2017-08-06 10:54 cwenao Exp $$
 */
public class RBTSimpleImplement<T extends Comparable> implements Serializable {

    private RBTNode<T> rbtRoot;

    private static final boolean RED = false;

    private static final boolean BLACK = true;

    public RBTSimpleImplement() {
        rbtRoot = null;
    }

    public void insert(T data) throws Exception {
        insert(rbtRoot, data);
    }

    private RBTNode<T> insert(RBTNode<T> node, T data) throws Exception {

        if (node == null) {
            node = new RBTNode<T>(data);
        }

        int left = data.compareTo(node.getData());

        if (left < 0) {
            node.setLeftNode(insert(node.getLeftNode(), data));

        } else if (left > 0) {
            node.setRightNode(insert(node.getRightNode(), data));
        }

        if (isRed(node.getRightNode()) && !isRed(node.getLeftNode())) {
            leftRotation(node);
        }

        if (isRed(node.getLeftNode()) && !isRed(node.getRightNode())) {
            rightRotation(node);
        }

        if (isRed(node.getLeftNode()) && isRed(node.getRightNode())) {
            flipColors(node);
        }

        return node;
    }

    /**
     * 沿着需要变化的节点记性逆时针旋转
     * @param node
     */
    private RBTNode<T> leftRotation(RBTNode<T> node) {

        RBTNode<T> tmpRBT = node.getRightNode();
        node.setRightNode(tmpRBT.getLeftNode());

        tmpRBT.setLeftNode(node);
        tmpRBT.setColor(node.getLeftNode().isColor());
        tmpRBT.getLeftNode().setColor(RED);

        return tmpRBT;

    }


    /**
     * 沿着节点顺时针旋转
     * @param node
     */
    private RBTNode<T> rightRotation(RBTNode<T> node) {

        RBTNode<T> tmpRBT = node.getLeftNode();
        node.setLeftNode(tmpRBT.getRightNode());

        tmpRBT.setRightNode(node);

        tmpRBT.setColor(node.getRightNode().isColor());
        tmpRBT.getRightNode().setColor(RED);

        return tmpRBT;
    }

    /**
     * 翻转颜色
     * @param node
     */
    private void flipColors(RBTNode<T> node) {
        node.setColor(!node.isColor());
        node.getLeftNode().setColor(!node.getLeftNode().isColor());
        node.getRightNode().setColor(!node.getRightNode().isColor());
    }

    private boolean isRed(RBTNode<T> node) {
        if (node == null) {
            return false;
        }
        return node.isColor() == RED;
    }
}
