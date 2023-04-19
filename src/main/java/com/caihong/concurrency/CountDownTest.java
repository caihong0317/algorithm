package com.caihong.concurrency;

import java.util.concurrent.CountDownLatch;

public class CountDownTest {
    private static CountDownLatch count = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(1);
                count.countDown();
            }
        });
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                count.countDown();
                System.out.println(2);
            }
        });
        a.start();
        b.start();
        count.await();
        System.out.println(3);
    }
}
