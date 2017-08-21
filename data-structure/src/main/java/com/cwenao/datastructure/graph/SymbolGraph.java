/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure.graph;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 符号图
 * 符号图：用于表示没有明确的V,E的图
 * @author cwenao
 * @version $Id SymbolGraph.java, v 0.1 2017-08-20 15:59 cwenao Exp $$
 */
public class SymbolGraph<T extends Comparable> {
    private static final Logger LOG = LoggerFactory.getLogger(SymbolGraph.class);

    private TreeMap<String, Integer> treeMap;

    private String[] keys;

    private Graph<Integer> graph;

    private String[][] storeKeys;

    public SymbolGraph(String fileName, String sp) {
        treeMap = new TreeMap<>();

        File file = new File(fileName);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            Scanner scanner = new Scanner(new BufferedInputStream(fileInputStream), "UTF-8");
            scanner.useLocale(Locale.CHINA);
            storeKeys = new String[100][];
            int count = 0;
            while (scanner.hasNextLine()) {
                String[] input = scanner.nextLine().split(sp);
                storeKeys[count] = input;
                for (int i=0;i<input.length;i++) {
                    if (treeMap.containsKey(input[i])) {
                        treeMap.put(input[i], i);
                    }
                }
                count++;
            }
            keys = new String[treeMap.size()];
            for (String key : treeMap.keySet()) {
                keys[treeMap.get(key)] = key;
            }

            graph = new Graph<>(treeMap.size());

            for (int i =0;i<count;i++ ) {
                String[] x = storeKeys[i];
                int v = treeMap.get(x[0]);

                for (int m = 1;m<x.length;m++) {
                    int w = treeMap.get(x[m]);
                    graph.addEdge(v, w);
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean contains(String s) {
        return treeMap.containsKey(s);
    }

    public int indexOf(String s) {
        return treeMap.get(s);
    }

    public String nameOf(int v) {
        return keys[v];
    }

    public Graph<Integer> graph() {
        return this.graph;
    }

}
