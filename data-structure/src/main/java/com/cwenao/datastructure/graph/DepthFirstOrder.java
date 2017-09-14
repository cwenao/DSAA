/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure.graph;

import java.util.Queue;

/**
 * @author cwenao
 * @version $Id DepthFirstOrder.java, v 0.1 2017-09-14 18:20 cwenao Exp $$
 */
public class DepthFirstOrder {
    private boolean[] marked;
    private int[] pre;
    private int[] post;

    private Queue<Integer> preOrder;
    private Queue<Integer> postOrder;

    private int preCounter;
    private int postCounter;

}
