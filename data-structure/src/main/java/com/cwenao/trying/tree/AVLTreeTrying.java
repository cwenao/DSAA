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

    /**
     * 插入后如果是 left and left情况则：围绕失衡点右转
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
     * 插入后 变成 right and right 情况则：围绕失衡点左转
     * @param avlNodeTrying
     * @return
     */
    public AVLNodeTrying<T> RRRotation(AVLNodeTrying<T> avlNodeTrying) {

        AVLNodeTrying<T> noBalance = avlNodeTrying.getRightNode();
        avlNodeTrying.setLeftNode(noBalance.getLeftNode());
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


}
