/*
 * Company
 * Copyright (C) 2014-2021 All Rights Reserved.
 */
package com.cwenao.data.coding.multithreading;

import java.util.concurrent.CompletableFuture;

/**
 * TODO : Statement the class description
 *
 * @author cwenao
 * @version $Id ThreadCompletableFuture.java, v1.0.0 2021-03-09 14:12 cwenao Exp $$
 */
public class ThreadCompletableFuture {

    public static void main(String[] args) throws InterruptedException {

        parallel();
        Thread.sleep(2000);
    }

    public static void parallel() {

        CompletableFuture<String> cfQueryFromSina = CompletableFuture.supplyAsync(()->{
            return queryCode("昆药集团", "https://finance.sina.com.cn/code/");
        });

        CompletableFuture<String> cfQueryFrom163 = CompletableFuture.supplyAsync(()->{
            return queryCode("昆药集团", "https://money.163.com/code/");
        });

        //查询Code合并为一个查询
        CompletableFuture<Object> cfQuery = CompletableFuture.anyOf(cfQueryFromSina, cfQueryFrom163);

        CompletableFuture<String> cfFetchFromSina = cfQuery.thenApplyAsync((code)->{
            return fetchPriceByCode((String) code,"https://finance.sina.com.cn/price/");
        });

        CompletableFuture<String> cfFetchFrom163 = cfQuery.thenApplyAsync((code)->{
            return fetchPriceByCode((String) code,"https://money.163.com/price/");
        });
        // 用anyOf合并为一个新的CompletableFuture
        CompletableFuture<Object> cfFetch = CompletableFuture
                .anyOf(cfFetchFromSina, cfFetchFrom163);

        cfFetch.thenAccept((result)->{
            System.out.println("merge query price: " + result);
        });

    }

    public static void normal() throws InterruptedException {
        //正常执行
        CompletableFuture completableFuture = CompletableFuture
                .supplyAsync(ThreadCompletableFuture::fetchPrice);

        completableFuture.thenAccept((result) ->{
            System.out.println("price: " + result);
        });

        completableFuture.exceptionally((e)->{
            ((Exception) e).printStackTrace();
            return null;
        });

        Thread.sleep(200);
    }

    public static void serialExecutor() throws InterruptedException {
        //多个CompletableFuture串行执行
        CompletableFuture<String> cfQueryCode = CompletableFuture
                .supplyAsync(()->{
                    return queryCode("昆药集团",null);
                });

        CompletableFuture <String> cfFetch = cfQueryCode.thenApplyAsync((code)->{
            return fetchPriceByCode(code,null);
        });

        cfFetch.thenAccept((result)->{
            System.out.println("the price is: " + result);
        });

        Thread.sleep(2000);
    }

    static double fetchPrice() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (Math.random() < 0.3) {
            throw new RuntimeException("fetch the price failed");
        }
        return 5 + Math.random() * 20;

    }

    static String queryCode(String name,String url) {
        System.out.println("query the name "+name+" from "+url);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "600422";
    }

    static String fetchPriceByCode(String code,String url) {
        System.out.println("query the code "+code+" from "+url);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "8.17";
    }

}
