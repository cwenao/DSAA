/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure.baseimplement;


/**
 * @author cwenao
 * @version $Id HashMapByLinerArray.java, v 0.1 2017-07-14 8:41 cwenao Exp $$
 */
public class HashMapByLinerArray<K,V> {

    private int currentKeyLen;

    private int mapLen;

    private K[] keys;

    private V[] values;

    private static final int INIT_CAPACITY = 20;

    public HashMapByLinerArray() {
        this(INIT_CAPACITY);
    }

    public HashMapByLinerArray(int len) {
        this.mapLen = len;
        keys = (K[]) new Object[mapLen];
        values = (V[]) new Object[mapLen];
    }

    public boolean contains(K key) {
        if (size() == 0) {
            return Boolean.FALSE;
        }

        return get(key) != null;
    }

    public int size() {
        return currentKeyLen;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private int hash(K key) {
        //0x7FFFFFFF 转换二进制为 0111 1111 1111 1111 1111 1111 1111 1111
        //hashcode 可能为负数，求 & 后则为正数，此处作为index所以需要正数
        return (key.hashCode() & 0x7FFFFFFF) % mapLen;
    }

    public V get(K key) {
        for (int i = hash(key) ;keys[i] !=null;i = (i+1) % mapLen) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    public void put(K key, V value) {
        if (key == null) {
            throw new NullPointerException("The key for map do not null");
        }

        if (currentKeyLen * 2 >= mapLen) {
            extendSize(mapLen * 2);
        }

        int i;
        for(i = hash(key); keys[i] !=null; i = (i+1) % mapLen) {
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }

        keys[i] = key;
        values[i] = value;
        currentKeyLen++;

    }

    public void remove(K key) {
        if (!contains(key)) {
            return;
        }

        int index = hash(key);

        while (!key.equals(keys[index])) {
            index = (index + 1) % mapLen;
        }

        keys[index] = null;
        values[index] = null;

        index = (index + 1) % mapLen;

        while (keys[index] != null) {
            K ktmp = keys[index];
            V vtmp = values[index];

            keys[index] = null;
            values[index] = null;

            currentKeyLen--;
            put(ktmp, vtmp);

            index = (index + 1) % mapLen;
        }

        currentKeyLen--;

        if (currentKeyLen * 2 > mapLen) {
            extendSize(mapLen * 2);
        }
    }

    private void extendSize(int extendLen) {
        HashMapByLinerArray<K, V> tmp = new HashMapByLinerArray<>(extendLen);

        for(int i =0 ;i < mapLen;i++) {
            if (keys[i] != null) {
                tmp.put(keys[i], values[i]);
            }
        }

        keys = tmp.keys;
        values = tmp.values;
        mapLen = tmp.mapLen;

    }

    public static void main(String[] args) {
        HashMapByLinerArray<String, String> hashMapByLinerArray = new HashMapByLinerArray<>(10);
        hashMapByLinerArray.put("a", "A");
        hashMapByLinerArray.put("b", "B");
        hashMapByLinerArray.put("c", "C");
        hashMapByLinerArray.put("d", "D");
        hashMapByLinerArray.put("e", "E");
        hashMapByLinerArray.put("F", "F");

        System.out.println(hashMapByLinerArray.size());

        System.out.println(hashMapByLinerArray.contains("a"));

        System.out.println(hashMapByLinerArray.mapLen);
        System.out.println(hashMapByLinerArray.currentKeyLen);
        hashMapByLinerArray.remove("a");
        System.out.println(hashMapByLinerArray.get("b"));
        System.out.println(hashMapByLinerArray.contains("a"));


    }

}

