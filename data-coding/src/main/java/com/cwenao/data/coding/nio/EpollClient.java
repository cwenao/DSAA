/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.data.coding.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id EpollClient.java, v1.0.0 2021-03-10 16:28 cwenao Exp $$
 */
public class EpollClient {

    public static void main(String[] args) {
        sendMsg();
    }

    private static void sendMsg() {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 8000));

            ByteBuffer readBuffer = ByteBuffer.allocate(32);
            ByteBuffer writeBuffer = ByteBuffer.allocate(32);

            writeBuffer.put("hello cwenao".getBytes(StandardCharsets.UTF_8));
            writeBuffer.flip();

            while (true) {
                writeBuffer.rewind();
                socketChannel.write(writeBuffer);

                readBuffer.clear();
                socketChannel.read(readBuffer);
                System.out.println("client: ----> "+new String(readBuffer.array()));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
