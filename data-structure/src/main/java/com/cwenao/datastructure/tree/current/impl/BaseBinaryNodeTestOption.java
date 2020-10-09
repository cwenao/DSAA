/**
 * Company Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.datastructure.tree.current.impl;

import com.cwenao.datastructure.tree.BinaryNode;

/**
 *
 * 创建测试树
 * @author cwenao
 * @version $Id TreeTest.java, v1.0.0 2020-08-12 21:03 cwenao Exp $$
 */
public class BaseBinaryNodeTestOption {

    public static BinaryNode createBinaryNode() {

        /**
         *           A
         *         /   \
         *       B       C
         *     /  \    /  \
         *    D    E  F    G
         *  /  \
         * H    I
         */

        BinaryNode rootNode = new BinaryNode("A");

        BinaryNode aLeftNode = new BinaryNode("B");
        BinaryNode aRightNode = new BinaryNode("C");

        BinaryNode bLeftNode = new BinaryNode("D");
        BinaryNode bRightNode = new BinaryNode("E");

        BinaryNode cLeftNode = new BinaryNode("F");
        BinaryNode cRightNode = new BinaryNode("G");

        BinaryNode dLeftNode = new BinaryNode("H");
        BinaryNode dRightNode = new BinaryNode("I");

        rootNode.setLeftNode(aLeftNode);
        rootNode.setRightNode(aRightNode);

        aLeftNode.setLeftNode(bLeftNode);
        aLeftNode.setRightNode(bRightNode);

        aRightNode.setLeftNode(cLeftNode);
        aRightNode.setRightNode(cRightNode);

        bLeftNode.setLeftNode(dLeftNode);
        bLeftNode.setRightNode(dRightNode);



        return rootNode;
    }

    public static BinaryNode createBinaryNodeByNum() {

        /**
         *           33
         *         /   \
         *      17     50
         *     /  \    /  \
         *   13    18  34  58
         *    \     \      / \
         *     16   25    51  66
         *          / \
         *         19  27
         */

        BinaryNode rootNode = new BinaryNode("33");

        BinaryNode node17 = new BinaryNode("17");
        BinaryNode node50 = new BinaryNode("50");

        BinaryNode node13 = new BinaryNode("13");
        BinaryNode node18 = new BinaryNode("18");

        BinaryNode node34 = new BinaryNode("34");
        BinaryNode node58 = new BinaryNode("58");

        BinaryNode node51 = new BinaryNode("51");
        BinaryNode node66 = new BinaryNode("66");

        BinaryNode node16 = new BinaryNode("16");
        BinaryNode node25 = new BinaryNode("25");

        BinaryNode node19 = new BinaryNode("19");
        BinaryNode node27 = new BinaryNode("27");


        rootNode.setLeftNode(node17);
        rootNode.setRightNode(node50);

        node17.setLeftNode(node13);
        node17.setRightNode(node18);

        node13.setRightNode(node16);

        node18.setRightNode(node25);

        node25.setLeftNode(node19);
        node25.setRightNode(node27);

        node50.setLeftNode(node34);
        node50.setRightNode(node58);

        node58.setLeftNode(node51);
        node58.setRightNode(node66);

        return rootNode;
    }
}
