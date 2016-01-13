package com.github.uryyyyyyy.javaSamples.redis.redisson;

import io.netty.util.concurrent.Future;
import org.redisson.Config;
import org.redisson.Redisson;
import org.redisson.RedissonClient;
import org.redisson.core.RBucket;

import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String args[]) throws ExecutionException, InterruptedException {
        Config config = new Config();
        config.useSingleServer().setAddress("172.17.0.2:6379").setDatabase(0);
        RedissonClient redisson = Redisson.create(config);

        RBucket<String> bucket = redisson.getBucket("myMap");
        bucket.set("hello");
        Future<String> future = bucket.getAsync();

        future.addListener(f -> {
            if (future.isSuccess()) {
                System.out.println(future.get());
            } else {
                // got error
                throw new RuntimeException(future.cause());
            }
        });
        redisson.shutdown();
    }
}
