/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying.tree;

/**
 * @author cwenao
 * @version $Id AVLTreeTrying.java, v 0.1 2017-10-16 12:30 cwenao Exp $$
 */
public class AVLTreeTrying<T extends Comparable> {

    protected AVLNodeTrying<T> root;

    public AVLTreeTrying() {
        root = null;
    }

    public void insert(T data) {
        root = insert(root, data);
    }

    public AVLNodeTrying<T> insert(AVLNodeTrying<T> nodeTrying, T data) {
        if (nodeTrying == null) {
            nodeTrying = new AVLNodeTrying<T>(data);
        }
        int left = data.compareTo(nodeTrying.getData());

        if (left < 0) {
            nodeTrying.setLeftNode(insert(nodeTrying.getLeftNode(), data));
            if (high(nodeTrying.getLeftNode()) - high(nodeTrying.getRightNode())>=2) {
                if (data.compareTo(nodeTrying.getLeftNode().getData()) < 0) {
                    nodeTrying = LLRotation(nodeTrying);
                } else {
                    nodeTrying = LRRoation(nodeTrying);
                }
            }
        } else if (left > 0) {
            nodeTrying.setRightNode(insert(nodeTrying.getRightNode(), data));
            if (high(nodeTrying.getLeftNode()) - high(nodeTrying.getRightNode()) >=2) {
                if (data.compareTo(nodeTrying.getRightNode().getData()) >= 0) {
                    nodeTrying = RRRotation(nodeTrying);
                } else {
                    nodeTrying = RLRoation(nodeTrying);
                }
            }
        }
        nodeTrying.setHigh(max(nodeTrying.getLeftNode(), nodeTrying.getRightNode()));
        return nodeTrying;
    }
    /**
     * 插入后如果是 left and left情况则：围绕失衡点(M)右转
     * 1. 获取失衡点M的左子树为A
     * 2. 设置失衡点左子树为A.getRightNode()
     * 3. 设置A.setLeftNode(M)
     *
     * @param avlNodeTrying
     * @return
     */
    public AVLNodeTrying<T> LLRotation(AVLNodeTrying<T> avlNodeTrying) {
        AVLNodeTrying<T> noBalance = avlNodeTrying.getLeftNode();
        avlNodeTrying.setLeftNode(noBalance.getRightNode());
        noBalance.setRightNode(avlNodeTrying);

        avlNodeTrying.setHigh(max(avlNodeTrying.getLeftNode(),avlNodeTrying.getRightNode())+1);
        noBalance.setHigh((max(noBalance.getLeftNode(), noBalance.getRightNode())) + 1);

        return noBalance;
    }

    /**
     * 插入后 变成 right and right 情况则：围绕失衡点M左转
     * 1. 获取失衡点M的右子树A
     * 2. 设置设置失衡点M右子树为A的左子树：M.setRightNode(A.getLeftNode())
     * 3. 设置A的左子树为M： A.setLeftNode(M)
     *
     * @param avlNodeTrying
     * @return
     */
    public AVLNodeTrying<T> RRRotation(AVLNodeTrying<T> avlNodeTrying) {

        AVLNodeTrying<T> noBalance = avlNodeTrying.getRightNode();
        avlNodeTrying.setRightNode(noBalance.getLeftNode());
        noBalance.setLeftNode(avlNodeTrying);

        avlNodeTrying.setHigh(max(avlNodeTrying.getLeftNode(),avlNodeTrying.getRightNode())+1);
        noBalance.setHigh((max(noBalance.getLeftNode(), noBalance.getRightNode())) + 1);

        return noBalance;
    }

    /**
     * left and right : 先RR一次（左转变成left and left） 再进行LL操作
     * @param avlNodeTrying
     * @return
     */
    public AVLNodeTrying<T> LRRoation(AVLNodeTrying<T> avlNodeTrying) {
        AVLNodeTrying<T> noBalance = RRRotation(avlNodeTrying);
        return LLRotation(noBalance);
    }

    /**
     * right and left : 先LL一次（右旋变成 right and right ） 再进行RR操作
     * @param avlNodeTrying
     * @return
     */
    public AVLNodeTrying<T> RLRoation(AVLNodeTrying<T> avlNodeTrying) {
        AVLNodeTrying<T> noBalance = LLRotation(avlNodeTrying);
        return RRRotation(noBalance);
    }

    private int max(AVLNodeTrying<T> leftNode, AVLNodeTrying<T> rightNode) {
        return high(leftNode) > high(rightNode) ? high(leftNode) : high(rightNode);
    }

    private int high(AVLNodeTrying<T> nodeTrying) {
        return nodeTrying.getHigh();
    }

    public static void main(String[] args) {

    }
}
