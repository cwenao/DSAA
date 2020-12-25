/*
 * Company
 * Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.leetcode.algs.first;

import java.util.LinkedList;
import java.util.Queue;
import org.w3c.dom.Node;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id FillRightForTree.java, v1.0.0 2020-12-25 08:35 cwenao Exp $$
 */
public class FillRightForTree {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
//        connectByRecursive(root.left,root.right);
        return connectByBFS(root);
    }

    private Node connectByBFS(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int currentQueueSize = queue.size();

            for (int i = 0; i < currentQueueSize; i++) {
                Node node = queue.poll();

                //连接当前层子节点
                if (i < currentQueueSize - 1) {
                    node.next = queue.peek();
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

        }
        return root;
    }

    private void connectByRecursive(Node left,Node right) {
        if (left == null || right == null) {
            return;
        }

        left.next = right;

        //同一节点下的左右子树
        connectByRecursive(left.left, left.right);
        connectByRecursive(right.left, right.right);

        //不同节点下的左右子树
        connectByRecursive(left.right, right.left);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
