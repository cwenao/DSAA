/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying.tree;

/**
 * 树定义
 * 结点的度：结点拥有的子树的数目。
 * 叶子：度为零的结点。
 * 分支结点：度不为零的结点。
 * 树的度：树中结点的最大的度。
 *
 * 层次：根结点的层次为1，其余结点的层次等于该结点的双亲结点的层次加1。
 * 树的高度：树中结点的最大层次。
 *
 * 二叉树性质：
 * 性质1：二叉树第i层上的结点数目最多为 2{i-1} (i≥1)。
 * 性质2：深度为k的二叉树至多有2{k}-1个结点(k≥1)。
 * 性质3：包含n个结点的二叉树的高度至少为log2 (n+1)。
 * 性质4：在任意一棵二叉树中，若终端结点的个数为n0，度为2的结点数为n2，则n0=n2+1
 *
 * @link http://www.cnblogs.com/skywang12345/p/3576328.html
 * @author cwenao
 * @version $Id BinarySearchTreeTrying.java, v 0.1 2017-10-20 08:44 cwenao Exp $$
 */
public class BinarySearchTreeTrying<T extends Comparable> {

    private BinaryNodeTrying<T> root;

    public BinarySearchTreeTrying() {
        root = null;
    }

    public BinaryNodeTrying<T> insert(T data, BinaryNodeTrying<T> node) {
        if (node == null) {
            node = new BinaryNodeTrying<T>(data);
        }

        int left = data.compareTo(node.getData());

        if (left < 0) {
            node = insert(data, node.getLeftNode());
        } else if (left > 0) {
            node = insert(data, node.getRightNode());
        }

        return node;
    }

    public BinaryNodeTrying<T> remove(T data, BinaryNodeTrying nodeTrying) {
        if (nodeTrying == null) {
            return null;
        }

        int left = data.compareTo(nodeTrying.getData());


        return nodeTrying;
    }

    /**
     * 查询右子树序列中不存在左子树的节点
     * @param nodeTrying
     * @return
     */
    public BinaryNodeTrying<T> findExcludeLeftNode(BinaryNodeTrying nodeTrying) {
        if (nodeTrying == null) {
            return null;
        }
        if (nodeTrying.getLeftNode() == null) {
            return nodeTrying;
        }

        return findExcludeLeftNode(nodeTrying.getRightNode());

    }


}
