package com.github.uryyyyyyy.javaSamples.jedis;

import redis.clients.jedis.*;

import java.util.HashSet;
import java.util.Set;

public class RedisClusterClient {

    public static void main(String[] args) {
        Set<HostAndPort> jedisClusterNodes = new HashSet<>();
//Jedis Cluster will attempt to discover cluster nodes automatically
        jedisClusterNodes.add(new HostAndPort("172.17.0.5", 6379));
        jedisClusterNodes.add(new HostAndPort("172.17.0.4", 6379));
        jedisClusterNodes.add(new HostAndPort("172.17.0.3", 6379));
        JedisCluster jc = new JedisCluster(jedisClusterNodes);

        jc.set("mykey", "Hello");
        System.out.println(jc.get("mykey"));

        // Keyを有効期限付きで登録
        System.out.print("setex(\"testKey\", 2, \"expireValue\"):");
        String resultString = jc.setex("testKey", 2, "expireValue");
        System.out.println(resultString);

        // 1秒待機
        System.out.println("Thread.sleep(1000)......");
        try { Thread.sleep(1000);}
        catch (InterruptedException e) {e.printStackTrace();}

        // Keyの有効期限を取得
        System.out.print("ttl(\"testKey\"):");
        long resultLong = jc.ttl("testKey");
        System.out.println(resultLong);

        System.out.println(jc.get("testKey"));

        // 2秒待機
        System.out.println("Thread.sleep(2000)......");
        try { Thread.sleep(2000);}
        catch (InterruptedException e) {e.printStackTrace();}

        // Keyの有効期限を取得
        System.out.println(jc.get("testKey"));
    }
}