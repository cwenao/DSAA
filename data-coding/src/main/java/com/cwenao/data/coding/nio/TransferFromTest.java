/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.data.coding.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id TransferFromTest.java, v1.0.0 2021-03-10 15:18 cwenao Exp $$
 */
public class TransferFromTest {

    public static void main(String[] args) {
        String fromPath = "/Users/cwenao/Desktop/redis-z.png";
        String toPath = "/Users/cwenao/Desktop/redis-z1.png";

//        transferFromChannel(fromPath, toPath);

        transferToChannel(fromPath, toPath);
    }

    private static void transferToChannel(String fromPath, String toPath) {

        try {
            RandomAccessFile fromFile = new RandomAccessFile(fromPath, "rw");
            FileChannel fromChannel = fromFile.getChannel();
            RandomAccessFile toFile = new RandomAccessFile(toPath, "rw");
            FileChannel toChannel = toFile.getChannel();

            fromChannel.transferTo(0, fromChannel.size(), toChannel);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void transferFromChannel(String fromPath, String toPath) {
        try {
            RandomAccessFile fromFile = new RandomAccessFile(fromPath, "rw");
            FileChannel fromChannel = fromFile.getChannel();

            RandomAccessFile toFile = new RandomAccessFile(toPath, "rw");
            FileChannel toChannel = toFile.getChannel();

            toChannel.transferFrom(fromChannel,0, fromChannel.size());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
