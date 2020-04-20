/**
 * Company Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.java.base.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 *
 * TODO : Statement the class description
 * @author cwenao
 * @version $Id InputStreamTest.java, v1.0.0 2020-01-06 14:55 cwenao Exp $$
 */
public class InputStreamTest {

    public void fileInputStreamTest(String name){

        BufferedInputStream bufferedInputStream= null;
        FileChannel fileChannel = null;

        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(name)));

            bufferedInputStream.mark(0);
            int countT = 0;
            int countB = 0;
            while (bufferedInputStream.read() != -1) {
                System.out.println("t++++"+countT+"    "+bufferedInputStream.toString());
                countT++;
            }

            bufferedInputStream.reset();

            while (bufferedInputStream.read() != -1) {
                System.out.println("b++++"+countB+"    "+bufferedInputStream.toString());
                countB++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        String testFile = "/Users/cwenao/myblog/_config.yml";
        InputStreamTest inputStreamTest = new InputStreamTest();

        inputStreamTest.fileInputStreamTest(testFile);

    }
}
