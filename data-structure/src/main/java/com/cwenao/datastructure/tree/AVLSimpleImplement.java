/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure.tree;

/**
 * AVL 树平衡：任何两个节点间的高度差最大为1
 * @author cwenao
 * @version $Id AVLSimpleImplement.java, v 0.1 2017-08-03 00:12 cwenao Exp $$
 */
public class AVLSimpleImplement<T extends Comparable> {

    protected AVLNode<T> root;

    public AVLSimpleImplement() {
        root = null;
    }

    public void insert(T data) {
        root = insert(root, data);
    }

    public AVLNode<T> insert(AVLNode<T> node, T data) {

        if (node == null) {
            node = new AVLNode<T>(data);
        }

        int left = data.compareTo(node.getData());

        if (left < 0) {
            node.setLeftNode(insert(node.getLeftNode(), data));

            if (height(node.getLeftNode()) - height(node.getRightNode()) >= 2) {
                //插入为左节点时成为左左情况
                if (data.compareTo(node.getLeftNode().getData()) < 0) {
                    node = LLRotation(node);
                } else {
                    //插入为右节点时为左右情况
                    node = LRRotation(node);
                }
            }
        } else if (left > 0) {
            node.setRightNode(insert(node.getRightNode(), data));
            if (height(node.getRightNode()) - height(node.getLeftNode()) >= 2) {
                if (data.compareTo(node.getRightNode().getData()) < 0) {
                    //为右左的情况
                    node = RLRotation(node);
                } else {
                    //为右右情况
                    node = RRRotation(node);
                }
            }
        }

        node.setHigh(max(height(node.getLeftNode()), height(node.getRightNode())));

        return node;
    }


    private int height(AVLNode<T> node) {
        if (node == null) {
            return 0;
        }
        return node.getHigh();
    }

    private int max(int source, int target) {
        return source > target ? source : target;
    }


    /**
     * left and left : 通过右旋一次（围绕失衡节点顺时针旋转）
     * @param avlNode
     * @return
     */
    private AVLNode<T> LLRotation(AVLNode<T> avlNode) {

        AVLNode<T> noBlance = avlNode.getLeftNode();

        avlNode.setLeftNode(noBlance.getRightNode());
        noBlance.setRightNode(avlNode);

        avlNode.setHigh(max(height(avlNode.getLeftNode()), height(avlNode.getRightNode())) + 1);
        noBlance.setHigh(max(height(noBlance.getLeftNode()), height(noBlance.getRightNode())) + 1);

        return noBlance;
    }

    /**
     * right and right : 通过左旋一次（围绕失衡节点逆时针旋转）
     * @param avlNode
     * @return
     */
    private AVLNode<T> RRRotation(AVLNode<T> avlNode)
    {
        AVLNode<T> noBlance = avlNode.getRightNode();

        avlNode.setRightNode(noBlance.getLeftNode());
        noBlance.setLeftNode(avlNode);

        avlNode.setHigh(max(height(avlNode.getLeftNode()), height(avlNode.getRightNode())) + 1);
        noBlance.setHigh(max(height(noBlance.getLeftNode()), height(noBlance.getRightNode())) + 1);

        return noBlance;
    }

    /**
     * left and right: 先对失衡节点左旋一次变成left and left,然后再右旋一次
     * @param avlNode
     * @return
     */
    private AVLNode<T> LRRotation(AVLNode<T> avlNode)
    {
        AVLNode<T> noBlance = RRRotation(avlNode);

        return LLRotation(noBlance);
    }

    /**
     * right and left: 先对失衡节点右旋一次变成right and right，然后再左旋一次
     * @param avlNode
     * @return
     */
    private AVLNode<T> RLRotation(AVLNode<T> avlNode)
    {
        AVLNode<T> noBlance = LLRotation(avlNode);
        return RRRotation(noBlance);
    }

}
