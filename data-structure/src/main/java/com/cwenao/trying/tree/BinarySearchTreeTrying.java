/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.trying.tree;

import java.util.ArrayDeque;
import java.util.Queue;

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

    /**
     * 插入
     * @param data
     * @param node
     * @return
     */
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

    /**
     * 需要判断删除的节点是否存在左右子树都不为空的时候，
     * 如果存在则需要在右子树序列中找到无左子树的节点
     * 然后依次替换
     * @param data
     * @param nodeTrying
     * @return
     */
    public BinaryNodeTrying<T> remove(T data, BinaryNodeTrying<T> nodeTrying) {
        if (nodeTrying == null) {
            return null;
        }

        int left = data.compareTo(nodeTrying.getData());

        if (left < 0) {
            nodeTrying.setLeftNode(remove(data, nodeTrying.getLeftNode()));
        } else if (left > 0) {
            nodeTrying.setRightNode(remove(data, nodeTrying.getRightNode()));
        } else if (nodeTrying.getLeftNode() != null && nodeTrying.getRightNode() != null) {
            //找到右子树序列中无左子树的节点
            //并将data替换为找到的值
            nodeTrying.setData(findExcludeLeftNode(nodeTrying.getRightNode()).getData());
            //替换右子树，依次保存有序与结构性
            nodeTrying.setRightNode(remove(nodeTrying.getData(), nodeTrying.getRightNode()));
        } else {
            nodeTrying = nodeTrying.getLeftNode() != null ? nodeTrying.getLeftNode() : nodeTrying.getRightNode();
        }

        return nodeTrying;
    }

    /**
     * 获取二叉树节点数
     * @param nodeTrying
     * @return
     */
    public int size(BinaryNodeTrying<T> nodeTrying) {
        if (null == nodeTrying) {
            return 0;
        }
        return size(nodeTrying.getLeftNode()) + 1 + size(nodeTrying.getRightNode());
    }

    /**
     * 判断是否存在
     * @param data
     * @return
     */
    public boolean isExist(T data) {

        if (null == root) {
            return false;
        }
        BinaryNodeTrying nodeTrying = isExist(data, root);
        if (nodeTrying == null) {
            return false;
        } else if (data.compareTo(nodeTrying.getData()) == 0) {
            return true;
        }

        return false;
    }

    private BinaryNodeTrying<T> isExist(T data, BinaryNodeTrying<T> nodeTrying) {
        if (null == nodeTrying) {
            return null;
        }

        int left = data.compareTo(nodeTrying.getData());

        if (left < 0) {
            if (nodeTrying.getLeftNode() == null) {
                return null;
            }
            isExist(data, nodeTrying.getLeftNode());
        } else if (left > 0) {
            if (nodeTrying.getRightNode() == null) {
                return null;
            }
            isExist(data, nodeTrying.getRightNode());
        }

        return nodeTrying;
    }

    /**
     * 先序遍历
     * 先遍历根节点，再遍历左子树 若左子树存在子节点则继续遍历，然后遍历右子树
     * @param nodeTrying
     * @return
     */
    public String preOrderTraversal(BinaryNodeTrying<T> nodeTrying) {
        if (null == nodeTrying) {
            return "";
        }

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(nodeTrying.getData() + ",");
        stringBuffer.append(preOrderTraversal(nodeTrying.getLeftNode()));
        stringBuffer.append(preOrderTraversal(nodeTrying.getRightNode()));
        return stringBuffer.toString();
    }

    /**
     * 中序遍历
     * 中序遍历先遍历左子树， 再遍历根节点，最后遍历右子树
     * @param nodeTrying
     * @return
     */
    public String inOrderTraversal(BinaryNodeTrying<T> nodeTrying){

        if (nodeTrying == null) {
            return "";
        }

        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append(inOrderTraversal(nodeTrying.getLeftNode()));
        stringBuffer.append(nodeTrying.getData() + ",");
        stringBuffer.append(inOrderTraversal(nodeTrying.getRightNode()));

        return stringBuffer.toString();
    }

    /**
     * 后序遍历：
     * 先遍历左子树，再遍历右子树，最后遍历根节点
     * @param nodeTrying
     * @return
     */
    public String postOrderTraversal(BinaryNodeTrying<T> nodeTrying) {
        if (null == nodeTrying) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        sb.append(nodeTrying.getLeftNode());
        sb.append(nodeTrying.getRightNode());
        sb.append(nodeTrying.getData());

        return sb.toString();
    }

    /**
     * 层序遍历：
     * 从左到右进行层序进行遍历
     * @param nodeTrying
     * @return
     */
    public String levelOrderTraversal(BinaryNodeTrying<T> nodeTrying) {
        Queue<BinaryNodeTrying> queue = new ArrayDeque<>();
        StringBuffer stringBuffer = new StringBuffer();

        BinaryNodeTrying temp = this.root;
        while (temp != null) {
            stringBuffer.append(temp.getData());
            if (temp.getLeftNode() != null) {
                queue.add(temp.getLeftNode());
            }
            if (temp.getRightNode() != null) {
                queue.add(temp.getRightNode());
            }
            temp = queue.poll();
        }

        return stringBuffer.toString();
    }

    /**
     * 获取最小节点
     * @param nodeTrying
     * @return
     */
    public BinaryNodeTrying<T> min(BinaryNodeTrying<T> nodeTrying) {

        if (nodeTrying == null) {
            throw new IllegalArgumentException("The Node can not NULL");
        }
        if (nodeTrying.getLeftNode() == null) {
            return nodeTrying;
        }
        return min(nodeTrying.getRightNode());
    }

    /**
     * 获取最大节点
     * @param nodeTrying
     * @return
     */
    public BinaryNodeTrying<T> max(BinaryNodeTrying<T> nodeTrying) {
        if (nodeTrying == null) {
            throw new IllegalArgumentException("The Node can not NULL");
        }
        if (nodeTrying.getRightNode() == null) {
            return nodeTrying;
        }
        return max(nodeTrying.getRightNode());
    }



    /**
     * 查询右子树序列中不存在左子树的节点
     * @param nodeTrying
     * @return
     */
    public BinaryNodeTrying<T> findExcludeLeftNode(BinaryNodeTrying<T> nodeTrying) {
        if (nodeTrying == null) {
            return null;
        }
        if (nodeTrying.getLeftNode() == null) {
            return nodeTrying;
        }

        return findExcludeLeftNode(nodeTrying.getRightNode());
    }

    /**
     * 查询左子树序列中不存在右子树的节点
     * @param nodeTrying
     * @return
     */
    public BinaryNodeTrying<T> findExcludeRightNode(BinaryNodeTrying<T> nodeTrying) {
        if (nodeTrying == null) {
            return null;
        }
        if (nodeTrying.getRightNode() == null) {
            return nodeTrying;
        }
        return findExcludeRightNode(nodeTrying.getLeftNode());
    }

}
