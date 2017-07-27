/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure.tree;

/**
 * @author cwenao
 * @version $Id BaseBinaryTree.java, v 0.1 2017-07-27 23:54 cwenao Exp $$
 */
public class BaseBinaryTree<T extends Comparable> implements BaseTree<T> {

    protected BinaryNode<T> root;

    public BaseBinaryTree() {
        root = null;
    }

    @Override
    public void insert(T data) {
        root = insert(data, root);
    }

    /**
     * 递归实现插入节点
     * @param data
     * @param node
     * @return
     */
    private BinaryNode<T> insert(T data, BinaryNode<T> node) {
        if (node == null) {
            node = new BinaryNode<T>(data);
        }

        int left = data.compareTo(node.getData());

        if (left < 0) {
            node = insert(data, node.getLeftNode());
        } else if (left > 0) {
            node = insert(data, node.getRightNode());
        }

        return node;
    }

    @Override
    public void remove(T data) {
        remove(data, root);
    }

    /**
     * 递归删除
     * 当遇到需要删除的节点存在左右子树时，找到右子树序列中不存在左子树的节点并替换掉需要删除的节点
     * 同时继续将节点指向挨个替换
     * 需要用右子树中无左子树的节点替换是因为这样的节点替换原有节点后
     * 会保持二叉树树的结构以及特性
     * @param data
     * @param node
     * @return
     */
    private BinaryNode<T> remove(T data, BinaryNode<T> node) {
        if (node == null) {
            return null;
        }

        int left = data.compareTo(node.getData());

        if (left < 0) {
            node.setLeftNode(remove(data, node.getLeftNode()));
        } else if (left > 0) {
            node.setRightNode(remove(data, node.getRightNode()));
        } else if (node.getLeftNode() != null && node.getRightNode() != null) {
            //找到右子树中无左子树的节点
            node.setData(findExcludeLeftNode(node.getRightNode()).getData());
            node.setRightNode(remove(node.getData(), node.getRightNode()));
        } else {
            node = node.getLeftNode() != null ? node.getLeftNode() : node.getRightNode();
        }
        return node;
    }

    /**
     * 查找没有左子树的节点
     * @param node
     * @return
     */
    private BinaryNode<T> findExcludeLeftNode(BinaryNode<T> node) {
        if (node == null) {
            return null;
        }
        if (node.getLeftNode() == null) {
            return node;
        }
        return findExcludeLeftNode(node.getLeftNode());
    }

    @Override
    public BinaryNode<T> findNode(T data) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    /**
     * 递归获取子节点
     * @param childNode
     * @return
     */
    private int size(BinaryNode<T> childNode) {
        if (childNode == null) {
            return 0;
        }
        return size(childNode.getLeftNode()) + 1 + size(childNode.getRightNode());
    }

    @Override
    public boolean contains(T data) {
        return contains(data, root);
    }

    /**
     *
     * @param data
     * @param node
     * @return
     */
    private boolean contains(T data, BinaryNode<T> node) {
        if (node == null) {
            return false;
        }

        int left = data.compareTo(node.getData());

        if (left < 0) {
            return contains(data, node.getLeftNode());
        } else if (left > 0) {
            return contains(data, node.getRightNode());
        } else {
            return true;
        }
    }
}
