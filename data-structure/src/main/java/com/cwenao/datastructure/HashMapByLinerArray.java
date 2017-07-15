/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.datastructure;


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
        return (key.hashCode() & 0x7FFFFFF) % mapLen;
    }

    public V get(K key) {
        for (int i = hash(key) ;keys[i] !=null;i = (i+1) % mapLen) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

}

