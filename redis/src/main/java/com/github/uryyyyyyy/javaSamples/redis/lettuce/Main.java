package com.github.uryyyyyyy.javaSamples.redis.lettuce;

import com.lambdaworks.redis.RedisClient;
import com.lambdaworks.redis.RedisFuture;
import com.lambdaworks.redis.RedisURI;
import com.lambdaworks.redis.api.StatefulRedisConnection;

import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String args[]) throws ExecutionException, InterruptedException {
        RedisClient redisClient = RedisClient.create(RedisURI.create("redis://172.17.0.2:6379"));
        StatefulRedisConnection<String, String> connection = redisClient.connect();

        String ok = connection.sync().set("key", "Hello, Redis!");
        System.out.println(ok);

        RedisFuture<String> fs =  connection.async().get("key");
        System.out.println(fs.get());

        connection.close();
        redisClient.shutdown();
    }
}
