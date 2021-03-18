/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.data.coding.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id EpollServerSocketChannelTest.java, v1.0.0 2021-03-11 11:21 cwenao Exp $$
 */
public class EpollServerSocketChannelTest {

    public static void main(String[] args) {
        epollServer();
    }

    private static void epollServer() {

        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress("127.0.0.1", 8000));
            serverSocketChannel.configureBlocking(false);

            Selector selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
            ByteBuffer writeBuffer = ByteBuffer.allocate(128);

            writeBuffer.put("EpollServerSocketChannelTest".getBytes(StandardCharsets.UTF_8));
            writeBuffer.flip();

            while (true) {
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    iterator.remove();

                    if (selectionKey.isAcceptable()) {
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        socketChannel.configureBlocking(false);

                        SelectionKey conditionKey = socketChannel
                                .register(selector, SelectionKey.OP_READ);
                        conditionKey.attach(new EpollTask(socketChannel, conditionKey));
                    } else if (selectionKey.isReadable()) {
                        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                        readBuffer.clear();
                        socketChannel.read(readBuffer);
                        readBuffer.flip();

                        EpollTask epollTask = (EpollTask)selectionKey.attachment();
                        epollTask.onRead(getInt(readBuffer));

                        selectionKey.interestOps(SelectionKey.OP_WRITE);
                    } else if (selectionKey.isWritable()) {
                        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                        writeBuffer.rewind();
                        EpollTask epollTask = (EpollTask) selectionKey.attachment();
                        epollTask.onWrite();

                        selectionKey.interestOps(SelectionKey.OP_READ);
                    }

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static int getInt(ByteBuffer buf) {
        int r = 0;
        while (buf.hasRemaining()) {
            r *= 10;
            r += buf.get() - '0';
        }

        return r;
    }



}
