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
public class RBTreeTrying<Key extends Comparable<Key>, Value> implements Serializable{

    private static final boolean RED = false;

    private static final boolean BLACK = true;

    private RBTNodeTrying root;


    public RBTreeTrying() {
        root = null;
    }

    public RBTNodeTrying put(Key key, Value value) {

        root = put(root, key, value);
        root.setColor(BLACK);

        return root;
    }

    public RBTNodeTrying put(RBTNodeTrying rbtNodeTrying, Key key, Value value) {
        if (rbtNodeTrying == null) {
            rbtNodeTrying = new RBTNodeTrying(key, value, this.RED);
        }

        int left = key.compareTo((Key) rbtNodeTrying.getKey());

        if (left < 0) {
            rbtNodeTrying.setLeft(put(rbtNodeTrying.getLeft(), key, value));
        } else if (left > 0) {
            rbtNodeTrying.setRight(put(rbtNodeTrying.getRight(), key, value));
        } else {
            rbtNodeTrying.setValue(value);
        }

        if (isRed(rbtNodeTrying.getRight()) && !isRed(rbtNodeTrying.getLeft())) {
            rbtNodeTrying = leftRotation(rbtNodeTrying);
        }
        if (isRed(rbtNodeTrying.getLeft()) && !isRed(rbtNodeTrying.getRight())) {
            rbtNodeTrying = rightRotation(rbtNodeTrying);
        }

        if (isRed(rbtNodeTrying.getLeft()) && isRed(rbtNodeTrying.getRight())) {
            flipColor(rbtNodeTrying);
        }
        rbtNodeTrying.setSize(rbtNodeTrying.getLeft().getSize() + rbtNodeTrying.getRight().getSize() + 1);

        return rbtNodeTrying;
    }


    private void flipColor(RBTNodeTrying rbtNodeTrying) {

        rbtNodeTrying.setColor(!rbtNodeTrying.isColor());
        rbtNodeTrying.getLeft().setColor(!rbtNodeTrying.getLeft().isColor());
        rbtNodeTrying.getRight().setColor(!rbtNodeTrying.getRight().isColor());

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

    public RBTNodeTrying balance(RBTNodeTrying<Key, Value> rbtNodeTrying) {
        if (isRed(rbtNodeTrying.getRight())) {
            rbtNodeTrying = leftRotation(rbtNodeTrying);
        }
        if (isRed(rbtNodeTrying.getLeft()) && isRed(rbtNodeTrying.getLeft().getLeft())) {
            rightRotation(rbtNodeTrying);
        }
        if (isRed(rbtNodeTrying.getLeft()) && isRed(rbtNodeTrying.getRight())) {
            flipColor(rbtNodeTrying);
        }

        rbtNodeTrying.setSize(rbtNodeTrying.getLeft().getSize() + rbtNodeTrying.getRight().getSize() + 1);

        return rbtNodeTrying;

    }

    public void delMax() {
        if (!isRed(root.getLeft()) && !isRed(root.getRight())) {
            root.setColor(RED);
        }
        root = delMax(root);
        if (root != null) {
            root.setColor(BLACK);
        }
    }

    /**
     * 删除最大值
     * @param rbtNodeTrying
     * @return
     */
    private RBTNodeTrying delMax(RBTNodeTrying<Key, Value> rbtNodeTrying) {
        if (isRed(rbtNodeTrying.getLeft())) {
            rbtNodeTrying = rightRotation(rbtNodeTrying);
        }
        if (rbtNodeTrying.getRight() == null) {
            return null;
        }

        if (!isRed(rbtNodeTrying.getRight()) && !isRed(rbtNodeTrying.getRight().getLeft())) {
            rbtNodeTrying = moveRight(rbtNodeTrying);
        }
        rbtNodeTrying.setRight(delMax(rbtNodeTrying.getRight()));
        return balance(rbtNodeTrying);

    }
    private RBTNodeTrying moveRight(RBTNodeTrying<Key, Value> rbtNodeTrying) {
        flipColor(rbtNodeTrying);
        if (isRed(rbtNodeTrying.getLeft().getLeft())) {
            rbtNodeTrying = rightRotation(rbtNodeTrying);
            flipColor(rbtNodeTrying);
        }
        return rbtNodeTrying;
    }

    private RBTNodeTrying moveLeft(RBTNodeTrying<Key, Value> rbtNodeTrying) {
        flipColor(rbtNodeTrying);
        if (isRed(rbtNodeTrying.getRight().getRight())) {
            rbtNodeTrying = leftRotation(rbtNodeTrying);
            flipColor(rbtNodeTrying);
        }
        return rbtNodeTrying;
    }

    public boolean isRed(RBTNodeTrying nodeTrying) {
        return RED == nodeTrying.isColor();
    }

    public int size(RBTNodeTrying nodeTrying) {
        return nodeTrying.getSize();
    }
}
