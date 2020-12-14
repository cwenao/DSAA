/*
  Company Copyright (C) 2014-2020 All Rights Reserved.
 */
package com.cwenao.data.coding.test;

import org.springframework.data.redis.core.RedisTemplate;

/**
 *
 * TODO : Statement the class description
 * @author cwenao
 * @version $Id TestRedis.java, v1.0.0 2020-11-10 15:34 cwenao Exp $$
 */
public class TestRedis {

    private RedisTemplate redisTemplate;

    public void test() {
        redisTemplate.opsForValue().increment("goodsId", -5L);
    }

}
