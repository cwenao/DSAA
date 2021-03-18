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
 * @version $Id SelectorTest.java, v1.0.0 2021-03-10 15:31 cwenao Exp $$
 */
public class ServerSocketAndSelectorTest {

    public static void main(String[] args) {
        registerServerSocketChannel2Selector();
    }

    private static void registerServerSocketChannel2Selector() {

        try {
            //创建ServerSocketChannel
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress("127.0.0.1",8000));
            //设置为非阻塞
            serverSocketChannel.configureBlocking(false);

            //开启Selector
            Selector selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            //创建buffer
            ByteBuffer readBuffers = ByteBuffer.allocate(1024);
            ByteBuffer writeBuffers = ByteBuffer.allocate(128);

            writeBuffers
                    .put("registerServerSocketChannel2Selector".getBytes(StandardCharsets.UTF_8));
            writeBuffers.flip();

            while (true) {
                int nRead = selector.select();
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = keys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    iterator.remove();

                    if (selectionKey.isAcceptable()) {
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_READ);
                    } else if (selectionKey.isReadable()) {
                        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                        readBuffers.clear();
                        socketChannel.read(readBuffers);
                        readBuffers.flip();

                        System.out.println("received : "+ new String(readBuffers.array()));
                        selectionKey.interestOps(SelectionKey.OP_WRITE);
                    } else if (selectionKey.isWritable()) {
                        writeBuffers.rewind();
                        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                        socketChannel.write(writeBuffers);
                        selectionKey.interestOps(SelectionKey.OP_READ);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
