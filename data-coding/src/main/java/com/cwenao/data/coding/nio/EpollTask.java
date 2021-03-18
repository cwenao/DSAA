/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.data.coding.nio;

import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id EpollTask.java, v1.0.0 2021-03-11 14:47 cwenao Exp $$
 */
public class EpollTask {

    private SocketChannel socketChannel;

    private SelectionKey selectionKey;

    private ByteBuffer writeBuffer;

    public EpollTask(SocketChannel socketChannel, SelectionKey selectionKey) {
        this.socketChannel = socketChannel;
        this.selectionKey = selectionKey;
        writeBuffer = ByteBuffer.allocate(128);
    }

    public void onRead(int anInt) {



    }

    public void onWrite() {
    }
}
