/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure.tree;

import java.io.Serializable;

/**
 * (1) 每个节点是黑色，或者是红色。
 * (2) 根节点是黑色。
 * (3) 每个叶子节点是黑色。(这里叶子节点，是指为空(NIL)的叶子节点)
 * (4) 如果一个节点是红色的，则它的子节点必须是黑色的。
 * (5) 从一个节点到该节点的子孙节点的所有路径上包含相同数目的黑节点。
 *
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

        if (isRed(node.getLeftNode()) && isRed(node.getLeftNode().getLeftNode())) {
            rightRotation(node);
        }

        if (isRed(node.getLeftNode()) && isRed(node.getRightNode())) {
            flipColors(node);
        }

        return node;
    }

    /**
     * 给定key进行查询
     * @param data
     * @return
     */
    public RBTNode<T> search(T data) {
        return search(rbtRoot, data);
    }

    private RBTNode<T> search(RBTNode<T> node, T data) {

        if (node == null) {
            return null;
        }
        int left = node.getData().compareTo(data);

        if (left < 0) {
            return search(node.getLeftNode(), data);
        } else if (left > 0) {
            return search(node.getRightNode(), data);
        } else {
            return node;
        }
    }


    public void deleteNode(T data) {
        if (!isRed(rbtRoot.getLeftNode()) && !isRed(rbtRoot.getRightNode())) {
            rbtRoot.setColor(RED);
        }
        rbtRoot = deleteNode(rbtRoot, data);
    }

    private RBTNode<T> deleteNode(RBTNode<T> node, T data) {
        int left = node.getData().compareTo(data);
        if (left > 0) {
            if (!isRed(node.getLeftNode()) && !isRed(node.getLeftNode().getLeftNode())) {
                node = moveRedLeft(node);
            }
            node.setLeftNode(deleteNode(node.getLeftNode(), data));
        } else {
            if (isRed(node.getLeftNode())) {
                node = rightRotation(node);
            }
            if (data.compareTo(node.getData()) == 0 && node.getRightNode() == null) {
                return null;
            }

            if (!isRed(node.getRightNode()) && !isRed(node.getRightNode().getLeftNode())) {
                node = moveRedRight(node);
            }
            if (data.compareTo(node.getData()) == 0) {
                RBTNode<T> delNode = min(node);
                node.setData(delNode.getData());
                node.setRightNode(deleteMin(node.getRightNode()));
            } else {
                node.setRightNode(deleteNode(node.getRightNode(),data));
            }
        }
        return balance(node);
    }

    private RBTNode<T>  deleteMin(RBTNode<T>  node) {
        if (node.getLeftNode() == null)
            return null;

        if (!isRed(node.getLeftNode()) && !isRed(node.getLeftNode().getLeftNode()))
            node = moveRedLeft(node);

        node.setLeftNode(deleteMin(node.getLeftNode()));
        return balance(node);
    }

    private RBTNode<T> min(RBTNode<T> node) {
        if (node.getLeftNode() == null) {
            return node;
        }
        return min(node.getLeftNode());
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

    private RBTNode<T> balance(RBTNode<T> node) {
        if (node == null) {
            return null;
        }
        if (isRed(node.getRightNode())) {
            node = leftRotation(node);
        }
        if (isRed(node.getLeftNode()) && isRed(node.getLeftNode().getLeftNode())) {
            node = rightRotation(node);
        }
        if (isRed(node.getLeftNode()) && isRed(node.getRightNode())) {
            flipColors(node);
        }
        return node;
    }

    private RBTNode<T> moveRedLeft(RBTNode<T> node) {
        flipColors(node);
        if (isRed(node.getRightNode().getRightNode())) {
            node.setRightNode(rightRotation(node));
            node = leftRotation(node);
            flipColors(node);
        }
        return node;
    }

    private RBTNode<T> moveRedRight(RBTNode<T> node) {
        flipColors(node);
        if (isRed(node.getLeftNode().getLeftNode())) {
            node = rightRotation(node);
            flipColors(node);
        }
        return node;
    }

    private boolean isRed(RBTNode<T> node) {
        if (node == null) {
            return false;
        }
        return node.isColor() == RED;
    }
}
