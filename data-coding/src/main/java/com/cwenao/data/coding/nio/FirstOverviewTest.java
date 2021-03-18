/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.data.coding.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id FirstOverviewTest.java, v1.0.0 2021-03-10 14:47 cwenao Exp $$
 */
public class FirstOverviewTest {

    public static void main(String[] args) throws IOException {
        String path = "/Users/cwenao/Desktop/redis-z.png";
        readFileByRandom(path);
    }

    private static void readFileByRandom(String path) throws IOException {
        RandomAccessFile accessFile = new RandomAccessFile(path, "rw");
        FileChannel fileChannel = accessFile.getChannel();
        //创建capacity=48的bytebuffer
        ByteBuffer buffer = ByteBuffer.allocate(48);

        int bytesRead = fileChannel.read(buffer);
        while (bytesRead != -1) {
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.println(buffer.get());
            }
            buffer.clear();
            bytesRead = fileChannel.read(buffer);
        }
        accessFile.close();
    }

}
