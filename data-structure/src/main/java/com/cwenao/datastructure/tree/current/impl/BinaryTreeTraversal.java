/**
 * Company Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.datastructure.tree.current.impl;

import com.cwenao.datastructure.tree.BinaryNode;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * 二叉树的遍历
 * @author cwenao
 * @version $Id BinaryTreeTraversal.java, v1.0.0 2020-08-20 13:50 cwenao Exp $$
 */
public class BinaryTreeTraversal {

    /**
     * 先序遍历，root -> left -> right
     * ![先序遍历](http://image.cwenao.jikedo.com/%E5%85%88%E5%BA%8F%E9%81%8D%E5%8E%86.png)
     *
     *                     A
     *                   /   \
     *                 B       C
     *               /  \    /  \
     *              D    E  F    G
     *            /  \
     *           H    I
     *  输出顺序： A -> B -> D -> H -> I -> E -> C -> F -> G
     *
     * @param node
     * @return
     */
    public Map<String, BinaryNode> preOrderTraversal(BinaryNode<String> node, Map<String,BinaryNode> preOrderMap) {

        if (node == null) {
            return null;
        }

        preOrderMap.put(String.valueOf(node.getData()), node);

        preOrderTraversal(node.getLeftNode(),preOrderMap);

        preOrderTraversal(node.getRightNode(),preOrderMap);

        return preOrderMap;
    }

    /**
     * 中序遍历：leftNode -> rootNode -> rightNode
     *  ![中序遍历](http://image.cwenao.jikedo.com/%E4%B8%AD%E5%BA%8F%E9%81%8D%E5%8E%86.png)
     *                     A
     *                   /   \
     *                 B       C
     *               /  \    /  \
     *              D    E  F    G
     *            /  \
     *           H    I
     *
     *  输出顺序： H -> D -> I -> B -> E -> A -> F -> C -> G
     * @param node
     * @param inBinaryTree
     * @return
     */

    public Map<String, BinaryNode> inOrderTraversal(BinaryNode node, Map<String, BinaryNode> inBinaryTree) {

        if (node == null) {
            return null;
        }

        inOrderTraversal(node.getLeftNode(), inBinaryTree);

        inBinaryTree.put(String.valueOf(node.getData()), node);

        inOrderTraversal(node.getRightNode(), inBinaryTree);

        return inBinaryTree;

    }


    /**
     * 后序遍历：leftNode -> rightNode -> rootNode
     * ![后序遍历](http://image.cwenao.jikedo.com/%E5%90%8E%E5%BA%8F%E9%81%8D%E5%8E%86.png)
     *
     *                     A
     *                   /   \
     *                 B       C
     *               /  \    /  \
     *              D    E  F    G
     *            /  \
     *           H    I
     *
     *  输出顺序： H -> I -> D -> E -> B -> F -> G -> C -> A
     * @param binaryNode
     * @param postMap
     * @return
     */
    public Map<String, BinaryNode> postOrderTraversal(BinaryNode binaryNode, Map<String, BinaryNode> postMap) {

        if (binaryNode == null) {
            return null;
        }

        postOrderTraversal(binaryNode.getLeftNode(), postMap);

        postOrderTraversal(binaryNode.getRightNode(), postMap);

        postMap.put(String.valueOf(binaryNode.getData()), binaryNode);

        return postMap;
    }

    /**
     * 层序遍历
     *                     A
     *                   /   \
     *                 B       C
     *               /  \    /  \
     *              D    E  F    G
     *            /  \
     *           H    I
     *
     * 输出结果：A -> B -> C ->D -> E -> F -> G -> H - I
     * @param binaryNode
     */
    public void levelOrderTraversal(BinaryNode binaryNode, Map<String,BinaryNode> levelMap) {

        if (binaryNode == null) {
            return;
        }

        LinkedBlockingQueue<BinaryNode> blockingQueue = new LinkedBlockingQueue<BinaryNode>();

        BinaryNode node = binaryNode;

        while (node != null) {

            levelMap.put(String.valueOf(node.getData()), node);

            if (node.getLeftNode() != null) {
                blockingQueue.add(node.getLeftNode());
            }

            if (node.getRightNode() != null) {
                blockingQueue.add(node.getRightNode());
            }

            node = blockingQueue.poll();
        }
    }

    public static void main(String[] args) {
        BinaryTreeTraversal  binaryTreeTraversal= new BinaryTreeTraversal();

        BinaryNode rootNode = BaseBinaryNodeTestOption.createBinaryNode();

        Map<String, BinaryNode> traversalMap = new LinkedHashMap<>();

//        binaryTreeTraversal.preOrderTraversal(rootNode,traversalMap);
//        binaryTreeTraversal.inOrderTraversal(rootNode,traversalMap);
//        binaryTreeTraversal.postOrderTraversal(rootNode,traversalMap);

        binaryTreeTraversal.levelOrderTraversal(rootNode,traversalMap);

        for (Entry entry : traversalMap.entrySet()) {
            System.out.println(entry.getKey());
        }

    }


}
