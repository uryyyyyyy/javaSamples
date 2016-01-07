package com.github.uryyyyyyy.javaSamples.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisClient {

    public static void main(String[] args) {
        JedisPool pool = new JedisPool(new JedisPoolConfig(), "172.17.0.5");
        try (Jedis jedis = pool.getResource()) {
            jedis.set("mykey", "Hello");
            System.out.println(jedis.keys("*"));
            System.out.println(jedis.get("mykey"));
            jedis.del("mykey");
            System.out.println(jedis.keys("*"));

            // Keyを有効期限付きで登録
            System.out.print("setex(\"testKey\", 2, \"expireValue\"):");
            String resultString = jedis.setex("testKey", 200, "expireValue");
            System.out.println(resultString);

            // 1秒待機
            System.out.println("Thread.sleep(1000)......");
            try { Thread.sleep(10000);}
            catch (InterruptedException e) {e.printStackTrace();}

            // Keyの有効期限を取得
            System.out.print("ttl(\"testKey\"):");
            long resultLong = jedis.ttl("testKey");
            System.out.println(resultLong);

            System.out.println(jedis.get("testKey"));
        }
        pool.destroy();
    }
}