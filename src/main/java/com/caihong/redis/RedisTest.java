package com.caihong.redis;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

public class RedisTest {
    public static final RedissonClient client;
    public static final String lock = "goods";

    static {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        client = Redisson.create(config);
    }

    public static void main(String[] args) throws InterruptedException {
        RLock lock = client.getLock(RedisTest.lock);
        boolean flag = lock.tryLock(1, 5, TimeUnit.SECONDS);
        if (!flag) {
            System.out.println("lock fail");
            return;
        }

        try {
            System.out.println("lock ok");
            Thread.sleep(7000);
        } catch (Exception e) {
        } finally {
            if (lock.isHeldByCurrentThread()){
                lock.unlock();
            }
        }
        client.shutdown();
    }
}
