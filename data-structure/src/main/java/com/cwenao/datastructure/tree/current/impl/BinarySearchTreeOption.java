/**
 * Company Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.datastructure.tree.current.impl;

import com.cwenao.datastructure.tree.BaseTree;
import com.cwenao.datastructure.tree.BinaryNode;
import org.apache.commons.lang.StringUtils;

/**
 *
 * BST树几遍操作
 * @author cwenao
 * @version $Id BinarySearchTreeOption.java, v1.0.0 2020-08-20 15:07 cwenao Exp $$
 */
public class BinarySearchTreeOption<T extends Comparable> implements BaseTree<T> {

    private BinaryNode root;

    @Override
    public int size() {
        return size(root);
    }

    private int size(BinaryNode node) {
        if (node == null) {
            return 0;
        }
        return size(node.getLeftNode())+ size(node.getRightNode()) +1 ;
    }

    @Override
    public boolean contains(T data) {
        return contains(data, root);
    }

    private boolean contains(T data, BinaryNode node) {

        if (node == null) {
            return false;
        }

        int left = data.compareTo(node.getData());

        if (left < 0) {
            return contains(data, node.getLeftNode());
        } else if (left > 0) {
            return contains(data, node.getRightNode());
        } else if (node.getData().equals(data)) {
            return true;
        }

        return false;
    }

    @Override
    public void insert(T data) {
        root = insert(data,root);
    }

    private BinaryNode<T> insert(T data, BinaryNode node) {
        if (node == null) {
            return new BinaryNode<T>(data);
        }

        int left = data.compareTo(node.getData());

        if (left < 0) {
            node.setLeftNode(insert(data, node.getLeftNode()));
        } else if (left > 0) {
            node.setRightNode(insert(data, node.getRightNode()));
        }

        return node;
    }

    @Override
    public void remove(T data) {
        root = remove(data,root);
    }

    /**
     * 二叉查找树的删除操作
     * 1. 找到要删除的节点 A。
     * 2. 如果A同时存在左右子树则查找A节点右子树中最小的节点 B（根据BTS定义，查找不存在左子树的节点）
     *    否则将左子树或者右子树直接替换A节点
     * 3. 将B.data 赋值给A.data ,A.setData(B.getData);
     * 4. 重新设置A的右子树，删除B节点
     *
     *          *           33
     *          *         /   \
     *          *      17     50
     *          *     /  \    /  \
     *          *   13    18  34  58
     *          *    \     \      / \
     *          *     16   25    51  66
     *          *          / \
     *          *         19  27
     *
     *
     * @param data
     * @param node
     * @return
     */
    private BinaryNode remove(T data, BinaryNode<T> node) {

        if (node == null) {
            return null;
        }

        int left = data.compareTo(node.getData());

        if (left < 0) {
            node.setLeftNode(remove(data,node.getLeftNode()));
        } else if (left > 0) {
            node.setRightNode(remove(data, node.getRightNode()));
        } else if (node.getLeftNode() != null && node.getRightNode() != null) {
            //获取无左子树的节点
            node.setData(findExcludeLeftNode(node.getRightNode()).getData());
            //重置右子树,删除节点
            node.setRightNode(remove(node.getData(), node.getRightNode()));
        } else {
            node = node.getLeftNode() != null ? node.getLeftNode() : node.getRightNode();
        }

        return node;
    }

    @Override
    public int height() {
        return 0;
    }

    @Override
    public BinaryNode<T> findExcludeLeftNode(BinaryNode<T> node) {

        if (node == null) {
            return null;
        }

        if (node.getLeftNode() == null) {
            return node;
        }

        return findExcludeLeftNode(node.getLeftNode());
    }

    @Override
    public BinaryNode<T> findExcludeRightNode(BinaryNode<T> node) {

        if (node == null) {
            return null;
        }

        if (node.getRightNode() ==null) {
            return node;
        }

        return findExcludeRightNode(node.getRightNode());
    }

    @Override
    public BinaryNode<T> findNode(T data) {

        if (!StringUtils.isNotEmpty(String.valueOf(data))) {
            return null;
        }

        return findNode(data, root);
    }

    private BinaryNode<T> findNode(T data, BinaryNode node) {

        if (node != null) {

            int left = data.compareTo(node.getData());

            if (left < 0) {
                 return findNode(data, node.getLeftNode());
            } else if (left > 0) {
                 return findNode(data, node.getRightNode());
            } else {
                return node;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        BinarySearchTreeOption binarySearchTreeOption = new BinarySearchTreeOption();

        BinaryNode<String> binaryNode =  BaseBinaryNodeTestOption.createBinaryNodeByNum();
        binarySearchTreeOption.root = binaryNode;
//
//        BinaryNode<String> tmp = binarySearchTreeOption.findNode("11");

//        BinaryNode<String> rootNode = new BinaryNode<>("44");

//        rootNode.setLeftNode(new BinaryNode<>("33"));
//        rootNode.setRightNode(new BinaryNode<>("55"));

//        binarySearchTreeOption.root = rootNode;

//        binarySearchTreeOption.insert("11");

        binarySearchTreeOption.remove("25");

        System.out.println(binarySearchTreeOption.root.getData());

    }
}
