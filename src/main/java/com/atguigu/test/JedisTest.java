package com.atguigu.test;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.HashMap;
import java.util.Set;

public class JedisTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.111.128", 6379);
        String ping = jedis.ping();
        System.out.println("ping = " + ping);

//        HashMap<String, Double> map = new HashMap<>();
//        map.put("A", 100.0);
//        map.put("b", 10.0);
//        map.put("c", 1.0);
//        map.put("d", 1111.0);
//        jedis.zadd("salls",map);

        Set<Tuple> salls = jedis.zrangeWithScores("salls",0,4);
        for (Tuple sall : salls) {
            System.out.println(sall.getElement());
            System.out.println(sall.getScore());
        }

        jedis.close();
    }
}
