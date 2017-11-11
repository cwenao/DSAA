/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying.tree;

import java.io.Serializable;

/**
 * 红黑树
 * (1) 每个节点是黑色或者是红色。
 * (2) 根节点是黑色。
 * (3) 每个叶子节点是黑色。(这里叶子节点，是指为空(NIL)的叶子节点)
 * (4) 如果一个节点是红色的，则它的子节点必须是黑色的。
 * (5) 从一个节点到该节点的子孙节点的所有路径上包含相同数目的黑节点。
 * (6) 在插入或者删除的时候需要保持红黑树结构，进行顺时针或者逆时针旋转
 * @author cwenao
 * @version $Id RBTreeTrying.java, v 0.1 2017-11-06 08:29 cwenao Exp $$
 */
public class RBTreeTrying<T extends Comparable> implements Serializable{

    private static final boolean RED = false;

    private static final boolean BLACK = true;

    private RBTNodeTrying root;


    public RBTreeTrying() {
        root = null;
    }


    public RBTNodeTrying put(T data) {
        return null;
    }

    /**
     * 逆时针旋转
     * @param rbtNodeTrying
     * @return
     */
    private RBTNodeTrying leftRotation(RBTNodeTrying rbtNodeTrying) {

        RBTNodeTrying tmp = rbtNodeTrying.getRight();

        rbtNodeTrying.setRight(tmp.getLeft());
        tmp.setLeft(rbtNodeTrying);
        tmp.setColor(rbtNodeTrying.getLeft().isColor());
        rbtNodeTrying.getLeft().setColor(RED);

        return tmp;
    }

    /**
     * 顺时针旋转
     ∫* @param rbtNodeTrying
     * @return
     */
    private RBTNodeTrying rightRotation(RBTNodeTrying rbtNodeTrying) {
        RBTNodeTrying tmp = rbtNodeTrying.getLeft();

        rbtNodeTrying.setLeft(tmp.getRight());
        tmp.setRight(rbtNodeTrying);
        tmp.setColor(rbtNodeTrying.getRight().isColor());

        rbtNodeTrying.getRight().setColor(RED);

        return tmp;
    }



    public boolean isRed(RBTNodeTrying nodeTrying) {
        return RED == nodeTrying.isColor();
    }

    public int size(RBTNodeTrying nodeTrying) {
        return nodeTrying.getSize();
    }
}
