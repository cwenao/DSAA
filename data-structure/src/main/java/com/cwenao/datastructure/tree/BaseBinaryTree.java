/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure.tree;

import java.util.concurrent.LinkedBlockingQueue;

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
        return size(root);
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

    /**
     * 先序遍历：先遍历根节点再遍历左子树，如左子树有子节点则继续遍历，左子树遍历完成后
     * 遍历右子树
     * @param node
     * @return
     */
    public String preOrderTraversal(BinaryNode<T> node) {
        if (node != null) {
            return "";
        }
        StringBuffer preOrderBuffer = new StringBuffer();

        preOrderBuffer.append(node.getData() + ",");
        preOrderBuffer.append(preOrderTraversal(node.getLeftNode()));
        preOrderBuffer.append(preOrderTraversal(node.getRightNode()));

        return preOrderBuffer.toString();
    }

    /**
     * 中序遍历：先遍历左子树再遍历根节点再遍历右子树
     * @param node
     * @return
     */
    public String inOrderTraversal(BinaryNode<T> node) {
        if (node == null) {
            return "";
        }
        StringBuffer inOrderBuffer = new StringBuffer();

        inOrderBuffer.append(inOrderTraversal(node.getLeftNode()));
        inOrderBuffer.append(node.getData() + ",");
        inOrderBuffer.append(inOrderTraversal(node.getRightNode()));

        return inOrderBuffer.toString();
    }

    /**
     * 后序遍历：先遍历左子树再遍历右子树再遍历根节点
     * @param node
     * @return
     */
    public String postOrderTraversal(BinaryNode<T> node) {
        if (node == null) {
            return "";
        }
        StringBuffer postOrderBuffer = new StringBuffer();

        postOrderBuffer.append(postOrderTraversal(node.getLeftNode()));
        postOrderBuffer.append(postOrderTraversal(node.getRightNode()));
        postOrderBuffer.append(node.getData());

        return postOrderBuffer.toString();
    }

    /**
     * 层序遍历：借助队列将根节点的左右子树存入队列，然后再取出队列第一个
     * @return
     */
    public String levelOrderTraversal()  {

        //用于存储当前节点的子节点
        LinkedBlockingQueue<BinaryNode<T>> nodeQueue = new LinkedBlockingQueue();

        StringBuffer levelOrderBuffer = new StringBuffer();

        BinaryNode<T> node = this.root;

        while (node != null) {
            levelOrderBuffer.append(node.getData());

            if (node.getLeftNode() != null) {
                nodeQueue.add(node.getLeftNode());
            }
            if (node.getRightNode() != null) {
                nodeQueue.add(node.getRightNode());
            }
            node = nodeQueue.poll();
        }
        return levelOrderBuffer.toString();
    }

    /**
     * 先序遍历序列与中序遍历序列确定二叉树
     * 先序遍历：确定根节点与子节点关系（根节点-左节点-右节点）
     * 中序遍历：确认左右子节点关系（左节点-根节点-右节点）
     * @param preOrder
     * @param preOrderStart
     * @param preOrderEnd
     * @param inOrder
     * @param inOrderStart
     * @param inOrderEnd
     * @return
     */
    public BinaryNode<T> createTreeByPreOrderAndInOrder(T[] preOrder, int preOrderStart, int preOrderEnd, T[] inOrder, int inOrderStart, int inOrderEnd) {

        BinaryNode<T> node = new BinaryNode<T>(preOrder[preOrderStart]);

        if (preOrderStart == preOrderEnd && inOrderStart == inOrderEnd) {
            return node;
        }

        int inOrderRoot;

        for(inOrderRoot = preOrderStart;inOrderRoot<inOrderEnd;inOrderRoot++) {
            //先序遍历中根节点在中序遍历中的位置
            if (preOrder[preOrderStart].compareTo(inOrder[inOrderRoot]) == 0) {
                break;
            }
        }

        //获取中序遍历中左右子树的长度
        int leftLen = inOrderRoot - inOrderStart;
        int rightLen = inOrderEnd - inOrderRoot;

        if (leftLen > 0) {
            node.setLeftNode(createTreeByPreOrderAndInOrder(preOrder, preOrderStart + 1, preOrderStart + leftLen, inOrder, inOrderStart, inOrderRoot - 1));
        }
        if (rightLen > 0) {
            node.setRightNode(createTreeByPreOrderAndInOrder(preOrder, preOrderStart + leftLen + 1, preOrderEnd, inOrder, inOrderRoot + 1, inOrderEnd));
        }
        return node;
    }
}
